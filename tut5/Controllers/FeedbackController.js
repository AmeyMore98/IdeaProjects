var express = require('express');
var router = express.Router();
var bodyParser = require('body-parser');

router.use(bodyParser.urlencoded({ extended: true }));
router.use(bodyParser.json());
var Feedback = require('../model/FeedbackModel');


router.get('/', function (req, res) {
    Feedback.find({}, function (err, feedbacks) {
        if (err) return res.status(500).send("There was a problem finding the feedbacks.");
        res.status(200).send(feedbacks);
    });
});

router.get('/:fid', function (req, res) {
    Feedback.find({ fid : req.params.fid }, function (err, feedbacks) {
        if (err) return res.status(500).send("There was a problem finding the feedbacks.");
        res.status(200).send(feedbacks);
    });
});


router.post('/', function (req, res) {
    Feedback.create({ fid: req.body.fid, sid: req.body.sid, content: req.body.content },
        function (err, feedback) {
        if (err) return res.status(500).send("There was a problem adding the feedback.");
        if (!feedback) return res.status(404).send("No feedback found.");
        res.status(200).send("Feedback was added");
    });
});

router.delete('/:fid', function (req, res) {
    Feedback.remove(
        { fid: req.params.fid }, 
        function (err, feedback) {
        if (err) return res.status(500).send("There was a problem deleting the feedback.");
        res.status(200).send("Feedback was deleted");
    });
});

router.put('/:fid', function (req, res){
    Feedback.findOneAndUpdate(
        { fid: req.params.fid },
        { content: req.body.content},
        function(err, feedback){
            if (err) return res.status(500).send("There was a problem updating the feedback.");
            res.status(200).send("Feedback was updated");
        });
});

module.exports = router;