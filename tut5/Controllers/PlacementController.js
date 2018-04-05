var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Company = require('../model/CompanyModel');

// RETURNS ALL THE studentS IN THE DATABASE
router.get('/:comp_name', function (req, res) {
    Company.find({ name: req.params.comp_name }, { name: 1, recruited : 1 }, function (err, students) {
        if (err) return res.status(500).send("There was a problem finding the students.");
        res.status(200).send(students);
    });
});

// GETS A SINGLE student FROM THE DATABASE
router.post('/:comp_name/:sid', function (req, res) {
    Company.findOneAndUpdate(
        { name: req.params.comp_name }, 
        { $addToSet: { recruited: req.params.sid } }, 
        { projection : {password: 0}, returnNewDocument : true  },
        function (err, company) {
        if (err) return res.status(500).send("There was a problem finding the company.");
        if (!company) return res.status(404).send("No company found.");
        res.status(200).send("Student was added");
    });
});

// DELETES A student FROM THE DATABASE
router.delete('/:comp_name/:sid', function (req, res) {
    Company.findOneAndUpdate(
        { name: req.params.comp_name },
        { $pull: { recruited: req.params.sid }}, 
        function (err, company) {
        if (err) return res.status(500).send("There was a problem deleting the student.");
        res.status(200).send("Student was deleted");
    });
});

module.exports = router;