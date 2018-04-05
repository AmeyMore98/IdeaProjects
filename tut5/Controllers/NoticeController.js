var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Notice = require('../model/NoticeModel');



router.get('/', function (req, res) {
    Notice.find({}, function (err, notices) {
        if (err) return res.status(500).send("There was a problem finding the notices.");
        res.status(200).send(notices);
    });
});

router.get('/:nid', function (req, res) {
    Notice.find({ nid : req.params.nid }, function (err, notices) {
        if (err) return res.status(500).send("There was a problem finding the notices.");
        res.status(200).send(notices);
    });
});

// GETS A SINGLE student FROM THE DATABASE
router.post('/', function (req, res) {
    Notice.create({ nid: req.body.nid, content: req.body.content },
        function (err, notice) {
        if (err) return res.status(500).send("There was a problem finding the notice.");
        if (!notice) return res.status(404).send("No notice found.");
        res.status(200).send("Notice was added");
    });
});

// DELETES A student FROM THE DATABASE
router.delete('/:nid', function (req, res) {
    Notice.remove(
        { nid: req.params.nid }, 
        function (err, notice) {
        if (err) return res.status(500).send("There was a problem deleting the student.");
        res.status(200).send("Notice was deleted");
    });
});

router.put('/:nid', function (req, res){
    Notice.findOneAndUpdate(
        { nid: req.params.nid },
        { content: req.body.content},
        function(err, notice){
            if (err) return res.status(500).send("There was a problem updating the notice.");
            res.status(200).send("Notice was updated");
        });
});

module.exports = router;