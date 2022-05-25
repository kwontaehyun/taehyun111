<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="https://www.gstatic.com/charts/loader.js"></script>
	<style>
	@import url('https://cdn.jsdelivr.net/gh/orioncactus/pretendard/dist/web/static/pretendard.css');

	* {
	   font-family: Pretendard, -apple-system, BlinkMacSystemFont, system-ui, Roboto, 'Helvetica Neue', 'Segoe UI', 'Apple SD Gothic Neo', 'Noto Sans KR', 'Malgun Gothic', sans-serif;
	}
	.list {
	  height:914px;	
	}
	#piechart{
		float : left;
		margin-top : 250px;
		margin-left : 250px;
	}
	#piechart2{
		float : right;
		margin-right : 250px;
		margin-top : 250px;
	}
	

	</style>
</head>


<body>
<div class="list">
	<div>
		<span id="piechart" style="width: 500px; height: 400px;"></span> <span
			id="piechart2" style="width: 500px; height: 400px;"></span>
	</div>
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