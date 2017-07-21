$(function () {
	/* 导航栏特效 */
	var oldClass = '', newClass = '';
	$(".hov").mouseover(function (event) {
		var _this = $(this);
		oldClass = _this.attr('class');
		if (oldClass.indexOf('_visited') != -1) {
			newClass = oldClass.replace(/_visited/, '_hover');
			_this.removeClass(oldClass).addClass(newClass);
		} else {
			newClass = oldClass+'_hover';
			_this.removeClass(oldClass).addClass(newClass);
		}
		return ;
	}).mouseout(function (event) {
		var _this = $(this);
		_this.removeClass(newClass).addClass(oldClass);
		return ;
	});
});

if(!Array.prototype.indexOf){
    Array.prototype.indexOf=function(el, index){
        var n = this.length>>>0, i = ~~index;
        if(i < 0) i += n;
        for(; i < n; i++) if(i in this && this[i] === el) return i;
        return -1;
    }
}