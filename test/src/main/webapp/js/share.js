var searchCondition = "${param.searchCondition}"
		jQuery(document).ready(function($){
			$(".sel option:selected").val();
			if(searchCondition == 0){
				$(".sel").val("0");
			}
			else if(searchCondition == 1){
				$(".sel").val("1");
			}
			else if(searchCondition == 2){
				$(".sel").val("2");
			}
		});