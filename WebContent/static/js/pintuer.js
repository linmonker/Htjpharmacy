$(function() {
	$(".win-forward").click(function() {
		window.history.forward(1);
	});
	$(".win-back").click(function() {
		window.history.back(-1);
	});
	$(".win-backtop").click(function() {
		$('body,html').animate({
			scrollTop : 0
		}, 1000);
		return false;
	});
	$(".win-refresh").click(function() {
		window.location.reload();
	});
	$(".win-print").click(function() {
		window.print();
	});
	$(".win-close").click(function() {
		window.close();
	});
	
	$('textarea, input, select').blur(function(){
		var e=$(this);
		if(e.attr("data-validate")){
			e.closest('.form-group').find(".input-help").remove();
			var $checkdata=e.attr("data-validate").split(',');
			var $checkvalue=e.val();
			var $checkstate=true;
			var $checktext="";
			if(e.attr("placeholder")==$checkvalue){$checkvalue="";}
			if($checkvalue!="" || e.attr("data-validate").indexOf("required")>=0){
				for(var i=0;i<$checkdata.length;i++){
					var $checktype=$checkdata[i].split(':');
					if($checktype[0]=="equalTo"){
						var $compareval = $($checktype[1]).val();
						if($compareval!='' && $checkvalue!=$compareval){
							$checkstate=false;
							$checktext=$checktext+"密码不一致";
						}
					}else if(!$pintuercheck(e,$checktype[0],$checkvalue)){
						$checkstate=false;
						$checktext=$checktext+$checktype[1];
					}
				}
			};
			if($checkstate){
				e.parent().find(".input-help").remove();
			}else{
				e.closest('.form-group').append('<span class="input-help errormsg">'+$checktext+'</span>');
			}
		}
	});
	$pintuercheck = function(element, type, value) {
		$pintu = value.replace(/(^\s*)|(\s*$)/g, "");
		switch (type) {
		case "required":
			return /[^(^\s*)|(\s*$)]/.test($pintu);
			break;
		case "chinese":
			return /^[\u0391-\uFFE5]+$/.test($pintu);
			break;
		case "number":
			return /^\d+$/.test($pintu);
			break;
		case "integer":
			return /^[-\+]?\d+$/.test($pintu);
			break;
		case "plusinteger":
			return /^[+]?\d+$/.test($pintu);
			break;
		case "double":
			return /^[-\+]?\d+(\.\d+)?$/.test($pintu);
			break;
		case "plusdouble":
			return /^[+]?\d+(\.\d+)?$/.test($pintu);
			break;
		case "english":
			return /^[A-Za-z]+$/.test($pintu);
			break;
		case "username":
			return /^[a-z]\w{3,}$/i.test($pintu);
			break;
		case "mobile":
			return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/
					.test($pintu);
			break;
		case "phone":
			return /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/
					.test($pintu);
			break;
		case "tel":
			return /^((\(\d{3}\))|(\d{3}\-))?13[0-9]\d{8}?$|15[89]\d{8}?$|170\d{8}?$|147\d{8}?$/
					.test($pintu)
					|| /^((\(\d{2,3}\))|(\d{3}\-))?(\(0\d{2,3}\)|0\d{2,3}-)?[1-9]\d{6,7}(\-\d{1,4})?$/
							.test($pintu);
			break;
		case "email":
			return /^[^@]+@[^@]+\.[^@]+$/.test($pintu);
			break;
		case "ip":
			return /^[\d\.]{7,15}$/.test($pintu);
			break;
		case "qq":
			return /^[1-9]\d{4,10}$/.test($pintu);
			break;
		case "currency":
			return /^\d+(\.\d+)?$/.test($pintu);
			break;
		case "zip":
			return /^[1-9]\d{5}$/.test($pintu);
			break;
		case "radio":
			var radio = element.closest('form').find(
					'input[name="' + element.attr("name") + '"]:checked').length;
			return eval(radio == 1);
			break;
		default:
			var $test = type.split('#');
			if ($test.length > 1) {
				switch ($test[0]) {
				case "compare":
					return eval(Number($pintu) + $test[1]);
					break;
				case "regexp":
					return new RegExp($test[1], "gi").test($pintu);
					break;
				case "length":
					var $length;
					if (element.attr("type") == "checkbox") {
						$length = element.closest('form').find(
								'input[name="' + element.attr("name")
										+ '"]:checked').length;
					} else {
						$length = $pintu.replace(/[\u4e00-\u9fa5]/g, "***").length;
					}
					return eval($length + $test[1]);
					break;
				case "ajax":
					var $getdata;
					var $url = $test[1] + $pintu;
					$.ajaxSetup({
						async : false
					});
					$.getJSON($url, function(data) {
						// alert(data.getdata);
						$getdata = data.getdata;
					});
					if ($getdata == "true") {
						return true;
					}
					break;
				case "repeat":
					return $pintu == jQuery('input[name="' + $test[1] + '"]')
							.eq(0).val();
					break;
				default:
					return true;
					break;
				}
				break;
			} else {
				return true;
			}
		}
	};

})