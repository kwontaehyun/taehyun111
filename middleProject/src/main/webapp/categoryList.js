/**
 * 
 */

let cnt = 1;
let sale = 0;
let sales = 0;

fetch('categoryList.do?category=악세사리')
	.then(result => result.json())
	.then(result => {
		console.log(result);
		let div = document.createElement('div');
		div.className = "container px-4 px-lg-5 mt-5";
		let div2 = document.createElement('div');
		div2.className = "row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
		div.appendChild(div2)
		document.getElementById('list').appendChild(div);
		result.forEach((val, idx) => {

			if (idx % 8 == 0) {
				let btn = document.createElement('button');
				let spanBtn = document.getElementById("btn");
				btn.innerHTML = cnt;
				btn.setAttribute("id", `btn${cnt}`);
				btn.style.margin = "10px";
				btn.style.fontSize = "20px";
				btn.style.border = "1px solid blue"
				btn.style.background = "white";
				cnt++;
				spanBtn.appendChild(btn);
				document.getElementById('list').appendChild(spanBtn);
			}
			if (idx < 8) {
				div2.appendChild(firstPage(val))
			}
		})

		let btnAry = document.querySelectorAll('div > button');

		result.forEach((val, idx) => {
			btnAry.forEach((btn, btnIdx) => {
				btn.addEventListener('click', function() {
					if (btnIdx == 0) {
						if (idx < 8) {
							if (idx == 0) {
								div2.remove();
								div2 = document.createElement('div');
								div2.className = "row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
							}
							div2.appendChild(firstPage(val))
							div.appendChild(div2)
						}
					}
					else {
						if (idx < 8 * btnIdx) {
							if (idx == 8 * (btnIdx - 1)) {
								div2.remove();
								div2 = document.createElement('div');
								div2.className = "row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center"
							}
							div2.appendChild(firstPage(val))
							div.appendChild(div2)
						}
					}
				})
			})
		})
	})


	.catch(error => console.log(error));
function firstPage(val) {
	let div2 = document.createElement('div');
	div2.className = "row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center";
	let div3 = document.createElement('div');
	div3.className = "col mb-5"
	let aTag = document.createElement('a');
	let div4 = document.createElement('div');
	div4.className = "card h-100"
	let div5 = document.createElement('div');
	div5.className = "card-body p-4"
	let div6 = document.createElement('div');
	div6.className = "text-center"

	let h5 = document.createElement('h5')
	h5.className = "fw-bolder"

	let img = document.createElement('img');
	for (let field in val) {
		if (field == 'proDuctNum') {
			aTag.setAttribute("id", `aTag${val[field]}`)
			aTag.setAttribute("href", `http://localhost/middleProject/detailProduct.do?proDuctNum=${val[field]}`);
		}

		if (field == 'pImg') {
			img.src = "upload/" + val[field];
			img.width = 206;
			img.height = 137.33;
			div4.appendChild(img);
		}

		if (field == 'proDuctName') {
			h5.innerHTML = val[field];
			div6.appendChild(h5)
		}

		let price = document.createElement('span');
		let Saleprice = document.createElement('span')
		if (field == 'sale' || field == 'proDuctPrice') {

			if (field == "proDuctPrice") {
				sale = val[field];
			}

			if (field == 'sale') {

				if (val[field] != 0) {

					let saleDiv = document.createElement('div');
					saleDiv.className = "badge bg-dark text-white position-absolute"
					saleDiv.style.top = "0.5rem";
					saleDiv.style.right = "0.5rem";
					sales = val[field]

					saleDiv.innerHTML = `${val[field]}% `;
					div4.appendChild(saleDiv);

					let priceSale = sale - (sale * (val[field] / 100));
					Saleprice.innerHTML = `${priceSale} 원`;
					div6.appendChild(Saleprice)

					price.className = "text-muted text-decoration-line-through";
					price.innerHTML = `${sale} 원`;
					div6.appendChild(price)

				} else {
					price.className = "";
					price.innerHTML = `${sale} 원`;
					div6.appendChild(price)
				}

			}

		}
		aTag.style.textDecoration = "none";
		aTag.style.color = "black";
		div3.appendChild(div4)
		div3.appendChild(aTag)
		aTag.appendChild(div4)
		div4.appendChild(div5)
		div5.appendChild(div6)

	}
	let cardfooterDiv = document.createElement('div');
	cardfooterDiv.className = "card-footer p-4 pt-0 border-top-0 bg-transparent";
	let cardfooterDiv2 = document.createElement('div');
	cardfooterDiv2.className = "text-center"
	let cartAtag = document.createElement('a');
	cartAtag.className = "btn btn-outline-dark mt-auto"
	cartAtag.setAttribute("href", "#");
	cartAtag.innerHTML = "Add to cart";


	cardfooterDiv.appendChild(cardfooterDiv2)
	cardfooterDiv2.appendChild(cartAtag)
	div4.appendChild(cardfooterDiv)
	div2.appendChild(div3)
	return div3;
}

