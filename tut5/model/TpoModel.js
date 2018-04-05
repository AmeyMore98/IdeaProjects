var mongoose = require('mongoose');  
var TpoSchema = new mongoose.Schema({  
  name: String,
  email: String,
  password: String,
});
mongoose.model('Tpo', TpoSchema);

module.exports = mongoose.model('Tpo');