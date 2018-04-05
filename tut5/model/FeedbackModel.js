var mongoose = require('mongoose');  
var FeedbackSchema = new mongoose.Schema({  
  fid: Number,
  sid: Number,
  content: String
});
mongoose.model('Feedback', FeedbackSchema);

module.exports = mongoose.model('Feedback');