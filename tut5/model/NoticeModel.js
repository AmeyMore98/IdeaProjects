var mongoose = require('mongoose');  
var NoticeSchema = new mongoose.Schema({  
  nid: Number,
  content: String
});
mongoose.model('Notice', NoticeSchema);

module.exports = mongoose.model('Notice');