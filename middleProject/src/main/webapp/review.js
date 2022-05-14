/**
 * 
 */
 
 document.addEventListener("DOMContentLoaded", function(){
	
	fetch('review.do')
		.then(result => result.json())
		.then(result =>{
			console.log(result);
		})
		.catch(error => console.log(error))
	
})