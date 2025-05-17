$(function() {
	//alert("hello");
	$("#userList").click(function() {
		fetchList("user")
	});
	
	$("#addressList").click(function() {
		fetchList("address")
	});
});

function addForm(type) {
	modifyData("/myspringboot/"+type+"/form");
}

function editForm(type, id) {
	modifyData("/myspringboot/"+type+"/edit/"+id);
}
	
function modifyData(url) {
	$.ajax({
		type : "GET",
		url : url,
		success : function(data) {
			$(".panel-body").html(data);
		}
	});		
}	
	
function fetchList(type) {
	$.ajax({
		type : "GET",
		url : "/myspringboot/"+type+"/list",
		success : function(data) {
			$(".panel-body").html(data);
		}
	});
}