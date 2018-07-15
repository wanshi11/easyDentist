var jp = {};

jp.id = 0;
jp.speed = 1700;
jp.src = new Array("/images/banner.jpg","/images/banner1.jpg","/images/banner4.jpg","/images/banner5.jpg");
//"/images/banner/hqxjbanner.jpg" "/images/banner/jkzz_banner.jpg" all_on_4
jp.href = new Array("/zt/ycjz/","/zt/gpxcmb/","/zt/mbtm/","/zt/yxjz/");
jp.move = new Array(
	"", "", "","", "", "", "","",""

);

function jinit() {
	var tp = "";
	var tp2 = "";
	for (var i = 0; i < jp.src.length; i++) {
		tp += '<a href="' + jp.href[i] + '" id="shower' + i + '" style="background-image:url(' + jp.src[i] + ')" target="_blank"><div>' + jp.move[i] + '</div></a>';
		tp2 += "<span id='mile" + i + "'></span>";
	}
	$("#jflash").html(tp);
	$("#litindct").html(tp2);
	$("#leftarr").click(function() {
		clearInterval(jp.tot);
		jpre();
	});
	$("#rightar").click(function() {
		clearInterval(jp.tot);
		jnext();
	});
	jnext();
}
jp.actionmove = function(id) {
	//show this id
	if (id == 0) {
		/*setTimeout(function(){
			$("#bni-lxkg1").css({"left":"-61px",opacity:1});

		},800);
		setTimeout(function(){
			$("#bni-lxkg2").css({"left":"24px",opacity:1});
		},1500);
		setTimeout(function(){
			$("#bni-lxkg3").css({"left":"258px",opacity:1});
		},2500);
		*/


		setTimeout(function() {
			$("#mdm1").css({
				"left": "78px",
				opacity: 1
			});

		}, 800);
		setTimeout(function() {
			$("#mdm2").css({
				"left": "200px",
				opacity: 1
			});
		}, 1500);
		setTimeout(function() {
			$("#mdm3").css({
				"left": "290px",
				opacity: 1
			});
		}, 2500);


	} else if (id == 1) {
		setTimeout(function() {
			$("#bni-lzxxdn2").css({
				"left": "104px",
				opacity: 1
			});

		}, 1500);
		setTimeout(function() {
			$("#bni-lzxxdn1").css({
				"left": "161px",
				opacity: 1
			});
		}, 800);
		setTimeout(function() {
			$("#bni-lzxxdn3").css({
				"left": "108px",
				opacity: 1
			});
		}, 1000);

	} else
	/*if(id == 2){
		setTimeout(function(){
			$("#kcy01").css({"left":"20px","transform":"scale(1)",opacity:1});
		},1200);
		setTimeout(function(){
			$("#kcy02").css({"left":"20px",opacity:1});
		},800);
		setTimeout(function(){
			$("#kcy03").css({"left":"94px",opacity:1});
		},2000);
		setTimeout(function(){
			$("#bni-sqjz4").css({"left":"740px",opacity:1});
		},1600);
	}else*/
	if (id == 3) {
		/*setTimeout(function(){
			$("#bni-lxkg1").css({"left":"46px",opacity:1});
		},800);
		setTimeout(function(){
			$("#pic5b").css({"left":"229px",opacity:1});
		},1500);
		setTimeout(function(){
			$("#pic5c").css({"left":"89px","top":"272px",opacity:1});
		},2000);
*/
		setTimeout(function() {
			$("#bni-lxkg1").css({
				"left": "-61px",
				opacity: 1
			});

		}, 800);
		setTimeout(function() {
			$("#bni-lxkg2").css({
				"left": "24px",
				opacity: 1
			});
		}, 1500);
		setTimeout(function() {
			$("#bni-lxkg3").css({
				"left": "258px",
				opacity: 1
			});
		}, 2500);

	} else if (id == 4) {
		setTimeout(function() {
			$("#pic5a").css({
				"left": "46px",
				opacity: 1
			});
		}, 800);
		setTimeout(function() {
			$("#pic5b").css({
				"left": "229px",
				opacity: 1
			});
		}, 1500);
		setTimeout(function() {
			$("#pic5c").css({
				"left": "89px",
				"top": "272px",
				opacity: 1
			});
		}, 2000);


	} else if (id == 5) {
		setTimeout(function() {
			$("#pic1a").css({
				"left": "428px",
				opacity: 1
			});
		}, 1500);
		setTimeout(function() {
			$("#pic1b").css({
				"left": "526px",
				opacity: 1
			});
		}, 2500);

		setTimeout(function() {
			$("#pic1c").css({
				"left": "626px",
				opacity: 1
			});
		}, 3000);

		setTimeout(function() {
			$("#pic1d").css({
				"left": "560px",
				opacity: 1
			});
		}, 3500);
		setTimeout(function() {
			$("#pic1e").css({
				"left": "-67px",
				opacity: 1
			});
		}, 500);



	}
}
jp.autorun = function() {
	makenote();
	jp.tot = setTimeout(jnext, 9000);
}

function jnext() {
	var l = jp.src.length;
	var tp1 = 0;
	if (jp.id - 1 == -1) {
		tp1 = l - 1;
	} else {
		tp1 = jp.id - 1;
	}
	jp.actionmove(jp.id);
	$("#shower" + tp1).fadeOut({
		duration: jp.speed,
		easing: "swing"
	});
	$("#shower" + tp1 + " img").attr("style", "");
	$("#shower" + jp.id).fadeIn({
		duration: jp.speed,
		easing: "swing"
	});
	jp.id++;
	if (jp.id >= l) {
		jp.id = 0;
	}
	jp.autorun();
}

function jpre() {
	var l = jp.src.length;

	var tp1 = 0;
	var tp2 = 0;
	if (jp.id - 2 == -1) {
		tp1 = l - 1;
		tp2 = jp.id - 1;
	} else if (jp.id - 2 == -2) {
		tp1 = l - 2;
		tp2 = l - 1;
	} else {
		tp1 = jp.id - 2;
		tp2 = jp.id - 1;
	}
	jp.id = tp2;
	jp.actionmove(tp1);
	$("#shower" + tp1).fadeIn({
		duration: jp.speed,
		easing: "swing"
	});
	$("#shower" + tp2).fadeOut({
		duration: jp.speed,
		easing: "swing"
	});
	$("#shower" + tp2 + " img").attr("style", "");
	jp.autorun();
}

function makenote() {
	$("#litindct span").removeClass("hover");
	if (jp.id != 0) {
		$("#mile" + (jp.id - 1)).addClass("hover");
	} else {
		$("#mile" + (jp.src.length - 1)).addClass("hover");
	}
}

function toitem() {
	$("#litindct span").click(function() {
		clearInterval(jp.tot);
		var id = parseInt($(this).attr("id").substr(4));
		$("#shower" + id).fadeIn({
			duration: jp.speed,
			easing: "swing"
		});
		jp.actionmove(id);
		if (jp.id != 0) {
			$("#shower" + (jp.id - 1)).fadeOut({
				duration: jp.speed,
				easing: "swing"
			});
			$("#shower" + (jp.id - 1) + " img").attr("style", "");
			jp.id = id + 1;
		} else {
			$("#shower" + (jp.src.length - 1)).fadeOut({
				duration: jp.speed,
				easing: "swing"
			});
			$("#shower" + (jp.src.length - 1) + " img").attr("style", "");
		}
		jp.autorun();
	});
}
jinit();
toitem();
$(function() {
	
	

	
	
	
	
	
	$("#leftarr").css("opacity", 0);
	$("#rightar").css("opacity", 0);
	$("#allabout").hover(function() {
		$("#leftarr").css({
			left: "150px",
			opacity: 0.5
		});
		$("#rightar").css({
			right: "150px",
			opacity: 0.5
		});
	}, function() {
		$("#leftarr").css({
			left: "-30px",
			opacity: 0
		});
		$("#rightar").css({
			right: "-30px",
			opacity: 0
		});
	});
	$("#jflash").hover(function() {
		clearInterval(jp.tot);
	}, function() {
		jp.autorun();
	});

	$("#leftarr").hover(function() {
		$("#leftarr").css("opacity", 1);
	}, function() {
		$("#leftarr").css("opacity", 0.5);
	});
	$("#rightar").hover(function() {
		$("#rightar").css("opacity", 1);
	}, function() {
		$("#rightar").css("opacity", 0.5);
	});
})
