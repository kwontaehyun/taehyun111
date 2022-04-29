/**
 *  ajax.js
 */
// 비동기.

let value = 10;


setTimeout(function() {
	value += 5;
	console.log('hello ->' + value);
	setTimeout(function() {
		value += 3;
		console.log('hello2 ->' + value);
	}, 2000); // 1000 <- 단위 : 밀리세컨트. 1초.
	setTimeout(function() {
		value += 3;
		console.log('hello2 ->' + value);
	}, 3000); // 1000 <- 단위 : 밀리세컨트. 1초.

}, 2000); // 1000 <- 단위 : 밀리세컨트. 1초.



//fetch의 결과가 promise를 리턴
let success = true;
let promise = new Promise(function(resolve, reject) {
	if (success) {
		resolve('success');
	} else {
		reject('error');
	}
});

promise.then(function(result) {
	console.log(result);
})
	.then(function(result) {
		console.log(result);
	})
	.catch(function(err) {
		console.log(err);
	});


