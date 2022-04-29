let val = 6;

let promise = new Promise(function(resolve, reject) {
	val -= 1;
	if (val > 0) {
		resolve('success, ' + val);
	}
	else
		reject('error, ' + val);
});

promise.then(resolve => {
	return new Promise((resolve, reject) => {
		val -= 2;
		if(val > 0)
			console.log(resolve);
		else
			console.log(reject);
	});
	
}).catch(function(result) {
	console.log(result);
})