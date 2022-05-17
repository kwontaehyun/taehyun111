<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
</head>
<body>
	<span id="piechart" style="width: 900px; height: 500px;"></span>
	<span id="piechart2" style="width: 900px; height: 500px;"></span>
	<script type="text/javascript">
	google.charts.load('current', { 'packages': ['corechart'] });
	google.charts.setOnLoadCallback(drawChart);
	google.charts.setOnLoadCallback(genderChart);
	
	function drawChart() {
		var aryData = [];
		aryData.push(['Dept', 'cnt per dept']);
		fetch('prodChart.do')
			.then(result => result.json())
			.then(callBack)
			.catch(error => console.log(error));
		function callBack(empData) {
			for (let field in empData) {
				let ary = [];
				ary.push(field);
				ary.push(empData[field]);
				aryData.push(ary);
			}
			var data = google.visualization.arrayToDataTable(aryData);

			var options = {
				title: '남녀 가입 비율'
			};

			var chart = new google.visualization.PieChart(document.getElementById('piechart'));
			chart.draw(data, options);
		}
	}

	function genderChart() {
		var aryData = [];
		aryData.push(['Dept', 'cnt per dept']);


		 fetch('userChart.do')
	  	  .then(result => result.json())
	  	  .then(callBack)
	  	  .catch(error => console.log(error));
		 
		 function callBack(empData) {
				for (let field in empData) {
					let ary = [];
					ary.push(field);
					ary.push(empData[field]);
					aryData.push(ary);
				}
				var data = google.visualization.arrayToDataTable(aryData);

				var options = {
					title: '남녀 상품 비율'
				};

				var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
				chart.draw(data, options);
			}
	}
	
    </script>
</body>
</html>