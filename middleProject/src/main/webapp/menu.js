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
			liTag.appendChild(aTag);
			ulTag.appendChild(liTag);
		})
		div.prepend(ulTag);

	})
	.then(error => console.log(error))




