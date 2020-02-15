// JavaScript Document

var memberShow = function(val){
	var mem_div = $("."+val);
	var memli = mem_div.find(".doctorsWrapper li");
	var mem_len = memli.length;
	//alert(mem_len);
	var pop_info = mem_div.find(".popInfo");
	var layer_Mode = mem_div.find(".overlayer");
	var thumb1 = [];//缂撳瓨鏁扮粍
	var thumb2 = [];//缂撳瓨鏁扮粍
	var init_left,init_top;
	var hovertime;
	
	/*鍥剧墖浣嶇疆闅忔満鏄剧ず*/
	function imgRand(){
		//闅忔満鐢熸垚鏉＄洰锛屽姞杞介殢鏈虹殑鏍峰紡锛屾彃鍏om閲岄潰锛屽厛闅愯棌
		for(var i = 0; i<mem_len; i++){
			thumb1[i] = i;
			thumb2[i] = i;
		}
		
		var thumb1_len = thumb1.length;
		var thumb2_len = thumb2.length;

		var index = 0;
		(function(){
			if(index >= mem_len){
				return;
			}
			var s_index = parseInt(Math.random()*thumb2_len);	//鏄剧ず闅忔満鏁�
			memli.eq(thumb2[s_index]).css('visibility','visible');
			thumb2.splice(s_index,1);
			thumb2_len--;
			index++;
			window.setTimeout(arguments.callee,50);
		})();
	}
	
	imgRand();
	
	memli.bind({
		mouseover : function(e){
			e.stopPropagation();
			THIS = $(this);
			hovertime = setTimeout(function(){
				pop_info.fadeIn();
				var addinfo = THIS.find(".addInfo").html();
				pop_info.html(addinfo);
				var position = THIS.position();
				var new_left,new_top;
				var cssShadow;
				var _margin;
				
				if(position.left <= mem_div.width() - pop_info.width()){
					new_left = position.left +17;
					cssShadow = "imgShadow1";
					_margin = "left";
					pop_info.find("a").css("float","left");
					pop_info.find("img").css("float","left");
					pop_info.find(".addInfoList").css({"float":"left","margin-left":"-50px"});
					
				}
				if(position.left > mem_div.width() - pop_info.width()){
					new_left = position.left - THIS.width()*2-3 ;
					cssShadow = "imgShadow2";
					_margin = "right";
					pop_info.find("a").css("float","right");
					pop_info.find("img").css("float","right");
					pop_info.find(".addInfoList").css({"float":"right","margin-right":"-50px","text-align":"right"});
				}
				if(position.top <= mem_div.height() - pop_info.height()){
					new_top = position.top+14;
				}
				if(position.top > mem_div.height() - pop_info.height()){
					new_top = position.top - THIS.height()*2 - 4;	
				}
				
				pop_info.css({"top":new_top,"left":new_left});
				pop_info.find("img").addClass(cssShadow);
				if(_margin == "left"){
					pop_info.find(".addInfoList").animate({			   
						marginLeft: "10px"					   
					},
					300
					);	
				}
				else if(_margin == "right"){
					pop_info.find(".addInfoList").animate({			   
						marginRight: "10px"
					},
					300
					);		
				}
				
				layer_Mode.fadeTo("fast", 0.6);
			},300);
		},
		mouseout: function(){
			clearTimeout(hovertime);
		}
		
	});
	pop_info.bind({
			mouseout:function(e){
					layer_Mode.css({"display":"none"});
		pop_info.fadeOut(100);
		pop_info.html("");
				}
		});

}

