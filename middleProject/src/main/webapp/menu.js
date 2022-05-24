/**
 * 
 */

fetch('Productmenu.do')
	.then(result => result.json())
	.then(result => {
		let div = document.querySelector('#navbarSupportedContent');
		let ulTag = document.getElementById('ulTag');

		result.forEach(val => {
			let liTag = document.createElement('li');
			let aTag = document.createElement('a');
			aTag.innerHTML = val;
			aTag.className = "dropdown-item";
			aTag.setAttribute("id", `${val}`)
			aTag.setAttribute("href", `http://localhost/middleProject/category.jsp?category=${val}`)
			liTag.appendChild(aTag);
			ulTag.appendChild(liTag);
		})
		div.prepend(ulTag);

	})
	.catch(error => console.log(error))

fetch('cartCntCheck.do')
	.then(result => result.json())
	.then(result => {
		console.log(result)
		let cartCnt = document.querySelector('#CartCnt');
		cartCnt.innerHTML = result.length;

	})
	.catch(error => console.log(error))
	
	
	