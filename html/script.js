(function(global){

	global.changeIframeSrc = function(src){
		document.getElementById('iframe').setAttribute('src', src);
	}

	$(document).ready(function(){
		$('#button').on('click', function(){
			WebApp.test();
			WebApp.newActivity('http://10.10.10.235:6871/test.html', '테스트');
			//changeIframeSrc('http://www.daum.net');
		});

		$('#reload').on('click', function(){
			global.location.reload();
		});
	});

})(window);