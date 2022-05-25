<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<style>
	#piechart{
		float : left;
		margin-top : 100px;
		margin-left : 320px;
	}
	#piechart2{
		float : right;
		margin-right : 250px;
		margin-top : 100px;
	}
	h2{
	text-align: center;
	margin: 0 auto;
	margin-top : 80px;
	padding-top: 30px;
	height: 60px;
	font-weight: bold;
	}
	#all{
	border: 1px solid;
	width:100%;
	}
	</style>
</head>


<body>
	<div id="all">
<h2>Chart</h2>
		<span id="piechart" style="width: 500px; height: 500px;"></span> 
		<span id="piechart2" style="width: 500px; height: 500px;"></span>
	</div>
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
				title: '남녀 상품 비율',
					is3D: true,
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
					title: '남녀 가입 비율',
					is3D: true,
				};

				var chart = new google.visualization.PieChart(document.getElementById('piechart2'));
				chart.draw(data, options);
			}
	}
	
    </script>
</body>
</html>