
/*��֤�����,���ύ��*/
    function no_submit(){
        return true;
    }

    function notifyOnErrorInput(input){
        var message = input.data('validateHint');
        $.Notify({
            caption: 'Error',
            content: message,
            type: 'alert'
        });
    }
	
/*������*/
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
	
//����������� -���
		;(function($){
			var leftNav = {
				container : "",
				subcontainer : "",
				init : function(container,subcontainer){
					this.container = container;
					this.subcontainer = subcontainer;
					this.removeClickEvent();
					this.clearAllActive();
					this.addClickEvent();
					
				},
				clearAllActive : function(){
					//���active��Class
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).removeClass("active");
						
					});
				},
				addClickEvent : function(){
					//Ϊÿ��li��ӵ���¼�
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).click(function(){
							
							leftNav.clearAllActive();
							$(this).addClass("active");
							
						});
					});
					//��ֹ�¼�ð��
					$(this.subcontainer).click(function(event){
						event.stopPropagation();
					});
					//�������˵���Ӧ
					var $sublis = $(this.subcontainer).find("li");					
					$sublis.each(function(){
						$(this).click(function(){
							
							//$(this).parent("ul").css("display","block");
							
						});
					});
				},
				removeClickEvent : function(){
					//�Ƴ�����¼�
					var $lis = $(this.container).find("li");
					$lis.each(function(){
						$(this).unbind("click");
					});
				}
			}
			
			
			window.leftNav = leftNav;
			
		})(jQuery)