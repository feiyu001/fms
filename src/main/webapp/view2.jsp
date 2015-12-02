<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.HashMap"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="lib/bootstrap3/css/bootstrap-theme.css" rel="stylesheet">
<link href="lib/bootstrap3/css/bootstrap.css" rel="stylesheet">

<link href="lib/bootstrap3/css/button.css" rel="stylesheet">
<script src="lib/bootstrap3/js/bootstrap.js"></script>
<script src="lib/jquery/jquery.js"></script>

<style type="text/css">
.btn-file {
	position: relative;
	overflow: hidden;
}

.btn-file input[type=file] {
	position: absolute;
	top: 0;
	right: 0;
	min-width: 100%;
	min-height: 100%;
	font-size: 100px;
	text-align: right;
	filter: alpha(opacity = 0);
	opacity: 0;
	outline: none;
	background: white;
	cursor: inherit;
	display: block;
}

.left-buffer {
	padding-left: 10px;
}

.right-buffer {
	padding-right: 10px;
}

.top-buffer {
	padding-top: 10px;
}

.bottom-buffer {
	padding-bottom: 10px;
}
</style>
<script type="text/javascript">
	function downloadFile() {
		window.location.href = "/pdfReader/downLoad.spring";
	}

	function getFileList() {

		window.location.href = "/pdfReader/fileList.spring";
	}

	function initpage() {
		var height = document.body.scrollHeight;
		$("#id_file_viewer").attr("height", height - 40);
	}
</script>
<title>Insert title here</title>
</head>
<body onload="initpage()">
	<div>
		<div class="row clearfix">
			<div class="col-md-3 column">
				<br />
				<div class="left-buffer">
					<div class="bottom-buffer">
						<input type="text" class="form-control" id="fileName" />
					</div>
					<div class="bottom-buffer pull-right">
						<button type="button" class="btn btn-default btn-primary"
							style="width: 100px">搜索</button>
					</div>
					<div style="height: 600px">
							<iframe src="lib/fancytree/demo/test.html" name="nav"
								 frameborder="0" scrolling="no" height="100%">
							</iframe>
					</div>
				</div>
			</div>
			<div class="col-md-7 column" style="height: 800px">
				<iframe id="id_file_viewer"
					src="pdfjs/web/viewer.html?file=test3.pdf" frameborder="0"
					scrolling="no" width="100%"></iframe>
			</div>
			<div class="col-md-2 column">
				<div>
					<h4>酒店管理系统</h4>
					<small>xx上传于 2015-11-23</small>
				</div>
				<div>
					<label>文档列表</label>
				</div>
				<c:forEach items="${fileMap}" var="m">
					<ul>
						<li><strong>${m.key}<br /></strong></li>
						<c:forEach items="${m.value}" var="filename">
							<li>${filename}</li>
						</c:forEach>
					</ul>
				</c:forEach>
				<br />
				<hr>
				<div>
					<div>
						<form id="form1" method="post" enctype="multipart/form-data"
							action="/pdfReader/upload.spring" name="form1"
							class="ng-pristine ng-valid">
							<div>
								<input type="text" id="fileText" name="fileText"
									class="acxiom-input span12" readonly="readonly"> <span
									class="btn btn-default btn-file pull-right button button-border button-rounded button-primary">
									文件上传 <input type="file" name="uploadMeta" id="uploadMeta"
									onchange="document.getElementById('fileText').value=this.value;">
								</span>
							</div>

						</form>
					</div>
				</div>
				<div>

					<input type="button" id="choose" style="height: 32px;" value="文件下载"
						class="pull-right button button-border button-rounded button-primary"
						onclick="downloadFile();">
				</div>
			</div>
		</div>
	</div>
</body>
</html>