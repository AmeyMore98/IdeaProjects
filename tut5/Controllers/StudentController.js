var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Student = require('../model/StudentModel');


// RETURNS ALL THE studentS IN THE DATABASE
router.get('/', function (req, res) {
    Student.find({}, function (err, students) {
        if (err) return res.status(500).send("There was a problem finding the students.");
        res.status(200).send(students);
    });
});

// GETS A SINGLE student FROM THE DATABASE
router.get('/:id', function (req, res) {
    Student.findById(req.params.id, function (err, student) {
        if (err) return res.status(500).send("There was a problem finding the student.");
        if (!student) return res.status(404).send("No student found.");
        res.status(200).send(student);
    });
});

// DELETES A student FROM THE DATABASE
router.delete('/:id', function (req, res) {
    Student.findByIdAndRemove(req.params.id, function (err, student) {
        if (err) return res.status(500).send("There was a problem deleting the student.");
        res.status(200).send("Student: "+ student.name +" was deleted.");
    });
});

// UPDATES A SINGLE student IN THE DATABASE
router.put('/:id', function (req, res) {
    Student.findByIdAndUpdate(req.params.id, req.body, {new: true}, function (err, student) {
        if (err) return res.status(500).send("There was a problem updating the student.");
        res.status(200).send(student);
    });
});


module.exports = router;