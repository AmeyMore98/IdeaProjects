var mongoose = require('mongoose');  
var CompanySchema = new mongoose.Schema({  
  name: String,
  email: String,
  password: String,
  cid: Number,
  recruited: {
  	type: [Number]
  },
  applied: {
  	type: [Number]
  }
});
mongoose.model('Company', CompanySchema);

module.exports = mongoose.model('Company');