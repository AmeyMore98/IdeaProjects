var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Company = require('../model/CompanyModel');


// RETURNS ALL THE studentS IN THE DATABASE
router.get('/', function (req, res) {
    Company.find({}, function (err, companies) {
        if (err) return res.status(500).send("There was a problem finding the students.");
        res.status(200).send(companies);
    });
});

// GETS A SINGLE company FROM THE DATABASE
router.get('/:id', function (req, res) {
    Company.findById(req.params.id, function (err, company) {
        if (err) return res.status(500).send("There was a problem finding the company.");
        if (!company) return res.status(404).send("No company found.");
        res.status(200).send(company);
    });
});

// DELETES A company FROM THE DATABASE
router.delete('/:id', function (req, res) {
    Company.findByIdAndRemove(req.params.id, function (err, company) {
        if (err) return res.status(500).send("There was a problem deleting the company.");
        res.status(200).send("Company: "+ company.name +" was deleted.");
    });
});

// UPDATES A SINGLE company IN THE DATABASE
router.put('/:id', function (req, res) {
    Company.findByIdAndUpdate(req.params.id, req.body, {new: true}, function (err, company) {
        if (err) return res.status(500).send("There was a problem updating the company.");
        res.status(200).send(company);
    });
});


module.exports = router;