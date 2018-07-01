//菜单收缩按钮
$(function(){
	var flag=true;
	$("#slider").click(function(){
		if(flag){
			$("#left").hide();
			$("#mainframe").find(".maindiv").css('margin-left',10);
			$("#slider").removeClass("side_switch");
			$("#slider").addClass("side_switchl");
			flag=false;
		}else{
			$("#left").show();
			$("#mainframe").find(".maindiv").css('margin-left',190);
			$("#slider").removeClass("side_switchl");
			$("#slider").addClass("side_switch");
			flag=true;
		}
	})
		
	$(".folder").click(function () {
	    $('.item').stop();
	    $(this).siblings(".item").removeAttr("id");
	    if($(this).attr("id")=="open"){
	        $(this).removeAttr("id").siblings(".item").slideUp();
	    }else{
	        $(this).attr("id","open").next().slideDown().siblings(".item").slideUp();
	    }
	});
})


$(window.parent.document).find("#main").load(function(){
	var main = $(window.parent.document).find("#main");
	var mainLeft = $(window.parent.document).find(".left");
	var thisheight = $(window.parent.document).height();

	if ($.browser.msie && ($.browser.version == "6.0") && !$.support.style) { 
		$(window.parent.document).find("body").height(thisheight-200);
	} else{
		main.height(thisheight-200);
		mainLeft.height(thisheight-196);
	}
	
});
 $(function(){  
	   $('.table').each(function(){
			$(this).find('tr:odd').find('td').css("background","#f1f1f1");
	});

 }) 
