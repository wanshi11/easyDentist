// JavaScript Document
var huameiV3 = {
	init: function() {
		var _this = this;
		_this.moreItems();
		_this.slideMenu();
		_this.footerSlide();
		if ($(".stage1").length > 0) {
			_this.indexAnliSlide();
			_this.expertSlide();
		};
		_this.topSearch();
		_this.searchItems();
		/*椤堕儴鑿滃崟寤惰繜鍔犺浇*/
		setTimeout(function() {
			$(".menu ul").addClass("active");
		}, 500);
		setTimeout(function() {
			$(".topLogo .searchBox").fadeIn(600);
		}, 5000);
		/*棣栭〉鏂伴椈婊氬姩鎾斁*/

		function AutoScroll(obj) {
			var objHeight = $(obj).height();
			$(obj).find("ul:first").animate({
				marginTop: -objHeight + "px"
			}, 500, function() {
				$(this).css({
					marginTop: "0px"
				}).find("li:first").appendTo(this);
			});
		};
		if ($(".newsScroll")) {
			setInterval(function() {
				AutoScroll(".newsScroll")
			}, 4500);
		}
		/*hot鍥炬爣涓婁笅鎶栧姩*/
		setInterval(function(){
				$(".subMenuLinkBox a.hot,.zhutiWripper a.hot,.stage1Title span").toggleClass("active");
			},2000)
		


	},
	/*鏇村椤圭洰js*/
	moreItems: function() {
		$(".seoMenus").slide({
			mainCell: '.seoContentBox',
			titCell: '.seoFocus a',
			effect: 'fade',
			mouseOverStop:true,
			titOnClassName: 'active'
		})
	},
	/*slideDownMenu  椤堕儴涓嬫媺鑿滃崟*/
	slideMenu: function() {
		$(".banner .menu ul").slide({
			type: "menu",
			titCell: '.subNav',
			targetCell: '.subMenu',
			effect: 'slideDown',
			titOnClassName: 'active',
			delayTime:200, triggerTime:100
		});
		$(".banner .menu ul li").each(function(index, element) {
			var left = $(".banner .menu ul li").width() * index;
			$(".banner .menu ul li").eq(index).find(".subMenu").css({
				left: -left + 'px'
			});
			$(this).mouseleave(function(e) {
				e.preventDefault();
				$(this).removeClass("active").find(".subMenu").removeClass("active");
			});
		});
	},
	/*鐩戠鍗曚綅銆佹巿鏉冨悎浣滅瓑椤圭洰鍒囨崲js*/
	footerSlide: function() {
		$(".footerSlides").slide({
			mainCell: '.slideBox',
			titCell: '.slideFocus span',
			effect: 'fade',
			titOnClassName: 'active',
			trigger: 'click',
			endFun:function(i,c){
					var slideBox = document.getElementById("slideBox");
					slideBox.style.height = slideBox.children[i].offsetHeight+'px';
					if(i>0)slideBox.style.transition = slideBox.style.mozTransition= slideBox.style.webkitTransition="200ms";//娣诲姞鍔ㄧ敾鏁堟灉
				}
		});
	},
	/*stage1 妗堜緥瀵规瘮杞挱 瀹夊叏涓庢湇鍔＄鐞�   鐗归個涓撳*/
	indexAnliSlide: function() {
		/*妗堜緥瀵规瘮*/
		$(".stage3_a").slide({
			mainCell: '.stage3Box',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			interTime: 6000,
			delayTime:1200
		});
		$(".stage3_b").slide({
			mainCell: '.stage3Box',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			interTime: 6000,
			delayTime:1200
		});
		$(".stage3_c").slide({
			mainCell: '.stage3Box',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			interTime: 6000,
			delayTime:1200
		});
		$(".stage3_d").slide({
			mainCell: '.stage3Box',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			interTime: 6000,
			delayTime:1200
		});
		/*瀹夊叏涓庢湇鍔＄鐞�*/
		$(".stage1_a").slide({
			mainCell: '.stage1_anliBox',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			interTime: 6000,
			delayTime:1200
		});
		/*鐗归個涓撳*/
		$(".stage1_c").slide({
			mainCell: '.slideBox',
			titCell: '.focus',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
			autoPage: '<span></span>',
			autoPlay: true,
			mouseOverStop:true,
			titOnClassName: 'active',
			interTime: 6000,
			delayTime:1200
		});

	},
	/*stage1 浜嗚В涓庢煡鎵句笓瀹跺垏鎹�*/
	expertSlide: function() {
		/*鍙充晶涓撳鍒囨崲*/
		/*棣栧厛瀵归噷杩涜鍒嗙粍*/
		$(".doctorsWrapper li").each(function(i) {
			$(".doctorsWrapper li").slice(i * 12, i * 12 + 12).wrapAll("<ul></ul>");
		});
		$(".doctorsBox").slide({
			mainCell: '.doctorsWrapper',
			titCell: '',
			effect: 'leftLoop',
			prevCell: '.preBtn',
			nextCell: '.nextBtn',
		});
		/*鍙充晶涓撳榧犳爣绉诲叆鐗规晥*/
		memberShow("doctorsBox");
		/*鍙充晶涓撳涓庢煡鎵惧垏鎹�*/
		$(".stage1 .stage_b").slide({
			mainCell: '.slides',
			titCell: '.focus span',
			effect: 'fold',
			titOnClassName: 'active',
			startFun: function(i, c) {
				$(".stage1 .stage_b .focus .active_bg").css({
					left: i * 50 + '%'
				});
			}
		});
		/*宸︿晶涓撳澶у浘鍒囨崲*/
		$(".stage1 .stage_a").mouseenter(function() {
			$(".stage1 .stage_a").find(".preBtn,.nextBtn").fadeIn(600);
		}).mouseleave(function() {
			$(".stage1 .stage_a").find(".preBtn,.nextBtn").fadeOut(600);
		});
		$(".stage1").slide({
			mainCell: '.stage_a .slideBox',
			titCell: '.itemExperts a',
			effect: 'leftLoop',
			prevCell: '.stage_a .preBtn',
			nextCell: ' .stage_a .nextBtn',
			autoPlay: true,
			mouseOverStop:true,
			scroll: 1,
			vis: 1,
			interTime: 6500,
			titOnClassName: 'active'
		});

	},
	/*椤堕儴鎼滅储妗嗗垏鎹s*/
	topSearch: function() {
		$(".searchSwitchs").slide({
			mainCell: '.switchBox',
			titCell: '.switchBtn li',
			effect: 'fade',
			prevCell: '',
			nextCell: '',
			autoPlay: false,
			scroll: 1,
			vis: 1,
			interTime: 6500,
			titOnClassName: 'active'
		});
	},
	/*椤堕儴鎼滅储妗嗕笅鎷夊垪琛�*/
	searchItems: function() {
		function itemFun() {
			this.items = {};
		};
		itemFun.prototype = {
			// body...
			add: function(id, iArray) {
				this.items[id] = iArray;
			},
			exist: function(id) {
				if (typeof(this.items[id]) == "undefined") return false;
				return true;
			}
		};
		/*鍒濆鍖栦笅鎷夋暟鎹�*/
		var itemsObj1 = new itemFun();
		/*itemsObj1.add("0", ["鐗欓娇绉嶆", "鐗欓娇鐭", "鐗欓娇淇",鐗欓娇缇庣櫧","鐗欏懆娌荤枟", "鍎跨鐗欑", "闅愬舰鐭", "鍙ｈ厰鍏ㄧ"]);*/
		itemsObj1.add("0", [{
			src: "/swt/",
				txt: '鐗欓娇绉嶆'
			}, {
				src: "/swt/",
				txt: '鐗欓娇鐭'
			}, {
				src: "/swt/",
				txt: '鐗欓娇淇'
			}, {
				src: "/swt/",
				txt: '鐗欓娇缇庣櫧'
			}, {
				src: "/swt/",
				txt: '鐗欏懆娌荤枟'
			}, {
				src: "/swt/",
				txt: '鍎跨鐗欑'
			}, {
				src: "/swt/",
				txt: '闅愬舰鐭'
			}, {
				src: "/swt/",
				txt: '鍙ｈ厰鍏ㄧ'
			}]);
		//鎵句笓瀹舵悳绱㈡暟鎹�  $(".item3 ul")
		itemsObj1.add("0_11", [{
				src: "/swt/",
				txt: '鐗欓娇绉嶆'
			}, {
				src: "/swt/",
				txt: '鐗欓娇鐭'
			}, {
				src: "/swt/",
				txt: '鐗欓娇淇'
			}, {
				src: "/swt/",
				txt: '鐗欓娇缇庣櫧'
			}, {
				src: "/swt/",
				txt: '鐗欏懆娌荤枟'
			}, {
				src: "/swt/",
				txt: '鍎跨鐗欑'
			}, {
				src: "/swt/",
				txt: '闅愬舰鐭'
			}, {
				src: "/swt/",
				txt: '鍙ｈ厰鍏ㄧ'
			}

		]);
		//console.log(itemsObj.items);

		var isOpen = false,
			/*榛樿涓€绾ц彍鍗曟湭鍔犺浇锛屽皢涓嶈兘鐩存帴鍑哄彂浜岀骇涓嬫媺鍒楄〃鍔犺浇*/
			hasLink = false,
			/*涓嬫媺鑿滃崟鏄惁鍖呭惈閾炬帴*/
			hasNextSelect = false,
			parentActiveIndex = 0,
			tempName = "0"; /*鏄惁杩樻湁涓嬩竴绾т笅鎷夊垪琛�*/
		/*parseUlLists涓嬫媺鍒楄〃鏁版嵁濉厖*/

		function parseUlLists(obj, arrIndex, itemJson,hasLink) {
			var elementsStr = "";
			var dataSoure = itemJson.items[arrIndex];
			var ininLen = dataSoure.length;
			for (var i = 0; i < ininLen; i++) {
				if (hasLink) {
					elementsStr += "<li><a target='_blank' href='" + dataSoure[i].src + "' data-src='" + dataSoure[i].src + "'>" + dataSoure[i].txt + "</a></li>";
				} else {
					elementsStr += "<li><a href='javascript:void(0)'>" + dataSoure[i] + "</a></li>";
				}

			}
			var dataDropLists = obj;
			dataDropLists.empty().append(elementsStr).css({
				position: "absolute",
				left: 0,
				top: dataDropLists.parent().height()-1 + "px",
				width: dataDropLists.parent().width() + 'px'
			});

		};
		var obj1 = $(".item1");
		parseUlLists(obj1.children("ul"), '0', itemsObj1,true);
		$(".item1 i").on("click",function(){
						obj1.children("ul").stop().slideToggle(600)
			})
		obj1.find("li").each(function(){
				$(this).click(function(e) {
					var _this = $(this).parent("ul").siblings("i");
                    _this.attr("data-src", $(this).find("a").attr("data-src"));
					_this.text($(this).text());
					obj1.children("ul").slideUp(600);
					//闅忔満鏁版秷澶�
					obj1.find(".itemNum").fadeOut();

                });
			});
		
			$(".keywordSelect i").on("click",function(){
				$(".stage_b").css("overflow",'visible');
				var _self = $(this);
				var hasLink = true;
				var obj = $(this).siblings("ul");
				parseUlLists(obj, '0_11', itemsObj1,hasLink);
				obj.stop().slideToggle(600);
				obj.find("li").each(function(index, element) {
				$(this).click(function(e) {
					if(hasLink){
							_self.attr("data-src", $(this).find("a").attr("data-src"));
						}
					_self.text($(this).text());
					obj.stop().slideUp(600);
				});
			});		
			});	
		$(".switch1 .bt").on("click", function() {
			if($(".item1 i").attr("data-src")!= ""){
						$(this).attr({
					"href": $(".item1 i").attr("data-src"),
					"target": "_blank"
				});
			}else{
					alert("閫夋嫨鎮ㄦ兂瑕佹敼鍙樼殑閮ㄤ綅!")
				}		
		});
		$(".keywordSelect .bt").on("click", function() {
			if($(".keywordSelect i").attr("data-src")!=""){
			$(this).attr({
				"href": $(".keywordSelect i").attr("data-src"),
				"target": "_blank"
			});}else{
					alert("閫夋嫨鎮ㄦ兂瑕佹敼鍙樼殑閮ㄤ綅!")
			}
		});
		$(".keywordSelect ul,.item1 ul ").mouseleave(function(e) {
                $(this).slideUp(600);
            });
	},
	/*followNav js*/
	followNav: function() {
		var sTop = $(document).scrollTop();
		var followTop = 0;
		if ($(".popBox")) {
			if ($(".popBox").hasClass("popOpen")) {
				followTop += $(".popBox").height();
			}
		};
		followTop = followTop + $(".header").height() + $(".banner").height();
		if (sTop >= followTop) {
			$(".followNav").addClass("active");
		} else {
			$(".followNav").removeClass("active");
		}
		//console.log(followTop)
	}

};
$(function() {
	huameiV3.init();
	$(".bannerSlide").mouseenter(function(e) {
        $(this).find(".bt").fadeIn()
    }).mouseleave(function(e) {
         $(this).find(".bt").fadeOut()
    });



	if($("#sideNav").length>0){
			var pathUrl = window.location.pathname ;
			var hash = window.location.hash;
			var targetUl = $("#sideNav ul ");
			var urlArr=[];
			targetUl.find("li").each(function(index, element) {
                	urlArr.push($(this).find("a").attr("href"));
            });
			if(hash!=""){
					pathUrl=pathUrl+hash;
					hash = hash.split("#")[1];
					var i = $("."+hash).index();
					$(".expertWrapper .focus span").removeClass("active").eq(i).addClass("active");
				}
			for(var i=0,j=urlArr.length;i<j;i++){
					if(pathUrl ==urlArr[i] ){
						targetUl.find("li").eq(i).find("a").addClass("active");	
						}
				}
			
		}
		if($(".anliCon").length>0){
			var pathUrl = window.location.pathname ;
			var hash = window.location.hash;
			var targetUl = $(".anliCon .hd ul ");
			var urlArr=[];
			targetUl.find("li").each(function(index, element) {
                	urlArr.push($(this).find("a").attr("href"));
            });
			if(hash!=""){
							pathUrl=pathUrl+hash;
							hash = hash.split("#")[1];
							var i = $("."+hash).index();
							console.log(i)
							$(".anliCon .hd ul li").removeClass("on").eq(i).addClass("on");
								}
			for(var i=0,j=urlArr.length;i<j;i++){
					
					if(pathUrl ==urlArr[i] ){
						targetUl.find("li").removeClass("on").eq(i).addClass("on");	
						}
				}
		}
		
		
		
})
$(window).on("load scroll DomMouseScroll", function() {
	if ($(".followNav").length>0) {
		huameiV3.followNav();
	}
})

