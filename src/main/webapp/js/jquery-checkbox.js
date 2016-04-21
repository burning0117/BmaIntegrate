(function (jQuery) {
    $.fn.controlCheckBox= function(checkname){
       if($(this).attr("checked")){
           $("input[name='"+checkname+"']").attr("checked",true);
       }else{
           $("input[name='"+checkname+"']").attr("checked",false);
       }
    }
})(jQuery);