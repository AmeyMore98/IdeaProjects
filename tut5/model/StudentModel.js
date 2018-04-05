var mongoose = require('mongoose');  
var StudentSchema = new mongoose.Schema({  
  name: String,
  email: String,
  password: String,
  sid: Number,
  branch: String,
  year: Number,
  blacklisted: Boolean,
  placed: Boolean,
  placedAt: String
});
mongoose.model('Student', StudentSchema);

module.exports = mongoose.model('Student');