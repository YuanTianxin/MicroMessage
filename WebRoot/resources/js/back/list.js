
/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	if($("input[type=checkbox]:checked").size() == 0) {
		alert("请勾选您要删除的选项");
	}
	else {
	    $("#mainForm").attr("action",basePath + "DeleteBatch.action");
	    $("#mainForm").submit();
	}
}

/**
 * 调用后台单个删除方法
 * @param basePath
 * @param id
 */
function deleteOne(basePath,id) {
	$("#deleteOne").val(id);
	$("#mainForm").attr("action",basePath + "DeleteOne.action");
	$("#mainForm").submit();
}


/**
 * 实现选中一个checkbox其他的都被选中，取消一个其他的都被取消选中
 */
$(document).ready(function(){  
    $("#selectAll").click(function(){     
        if($(this).attr("checked")=="checked"){  
            $(":checkbox").not($(this)).attr("checked","checked");}  
         else{  
             $(":checkbox").not($(this)).removeAttr("checked");  
        }    
        });  
    });   