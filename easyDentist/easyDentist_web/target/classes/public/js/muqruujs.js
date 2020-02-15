var oMarquee = document.getElementById("mq"); //滚动对象
var iLineHeight = 125; //单行高度，像素
var iLineCount = $("#qasLen").val(); //实际行数(数据记录数)
var iScrollAmount = 5; //每次滚动高度，像素
function run() {
	oMarquee.scrollTop += iScrollAmount;
	if (oMarquee.scrollTop == iLineCount * iLineHeight)
		oMarquee.scrollTop = 0;
	if (oMarquee.scrollTop % iLineHeight == 0) {
		console.log(11);
		window.setTimeout("run()", 4500);
	} else {
		window.setTimeout("run()", 15);
	}
}
oMarquee.innerHTML += oMarquee.innerHTML;
window.setTimeout("run()", 4500);