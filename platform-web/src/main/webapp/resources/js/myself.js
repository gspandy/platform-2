

	
/*进度条*/
   $(function(){
        runPB1();
    });
    var interval1;
    function runPB1(){
        clearInterval(interval1);
        var pb = $("#pb1").data('progress');
        var val = 0;
        interval1 = setInterval(function(){
            val += 10;
            pb.set(val);
            if (val >= 100) {
                val = 0;
                clearInterval(interval1);
            }
        }, 100);
    }
    function flashPB1(){
        clearInterval(interval1);
        var pb = $("#pb1").data('progress');
        pb.set(0);
    }
    function stopPB1(){
        clearInterval(interval1);
    }
	
//左侧下拉导航 -插件
		;(function($){
			var leftNav = {
				container : "",
				subcontainer : "",
				init : function(container,subcontainer){
					this.container = container;
					this.subcontainer = subcontainer;
					//this.removeClickEvent();
					//this.clearAllActive();
					this.addClickEvent();
					
				},
				clearAllActive : function(){
					//清除active的Class
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).removeClass("active");
						
					});
				},
				addClickEvent : function(){
					//为每个li添加点击事件
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).click(function(){
							
							leftNav.clearAllActive();
							$(this).addClass("active");
                            pagitation.pageNo = 1;
                            pagitation.pageSize = 10;
							//加载网页
                           // $("#context_main").load($(this).attr("to"));
                            jumpToModule($(this).attr("to"));
                        });
					});
					//防止事件冒泡
					$(this.subcontainer).click(function(event){
						event.stopPropagation();
					});
					//子下拉菜单响应
					var $sublis = $(this.subcontainer).find("li");					
					$sublis.each(function(){
						$(this).click(function(){
							
							//$(this).parent("ul").css("display","block");
							
						});
					});
				}/*,
				removeClickEvent : function(){
					//移除点击事件
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).unbind("click");
					});
				}*/
			}
			
			
			window.leftNav = leftNav;
			
		})(jQuery)