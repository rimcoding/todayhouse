<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/layout/header.jsp"/>
<style>
*{
margin: 0;
padding: 0;
box-sizing: border-box;

}
main{
		height:300px;
        display:flex;
        justify-content: center;
}
footer{
	display: flex;
	justify-content: center;
}
.headerimage{
display: flex;
justify-content: center;
align-items: center;
position: relative;
}
h3{
margin-top:10px;
display: flex;
justify-content: center;
align-items: center;
}

.userinteror{
display: flex;
justify-content: center;
align-items: center;
}
.slider{
	display: flex;
    height: 240px;
    position: relative;
    margin: 0 auto;
    overflow: hidden; 
    /* 현재 슬라이드 오른쪽에 위치한 나머지 슬라이드 들이 보이지 않도록 가림 */
    justify-content: center;
    align-items: center;
}
.slider input[type=radio]{
    display: none;
}
ul.imgs{
    padding: 0;
    margin: 0;
    list-style: none;    
}
ul.imgs li{
    position: absolute;
    left: 640px;
    transition-delay: 1s; 
    /* 새 슬라이드가 이동해 오는 동안 이전 슬라이드 이미지가 배경이 보이도록 지연 */

    padding: 0;
    margin: 0;
}
.bullets{
	position: absolute;
	left: 50%;
	transform: translateX(-50%);
	bottom: 20px;
	z-index: 2;
}
.bullets label{
display: inline-block;
border-radius: 50%;
background-color: rgba(0,0,0,0,55);
width: 20px;
height: 20px;
cursor: pointer;
}

.slider input[type=radio]:nth-child(1):checked~.bullets>label:nth-child(1){
	background-color: #fff;
}
.slider input[type=radio]:nth-child(2):checked~.bullets>label:nth-child(2){
	background-color: #fff;
}
.slider input[type=radio]:nth-child(3):checked~.bullets>label:nth-child(3){
	background-color: #fff;
}

.slider input[type=radio]:nth-child(1):checked~ul.imgs>li:nth-child(1){
    left: 0;
    transition: 0.5s;
    z-index:1;
}

.slider input[type=radio]:nth-child(2):checked~ul.imgs>li:nth-child(2){
    left: 0;
    transition: 0.5s;
    z-index:1;
}

.slider input[type=radio]:nth-child(3):checked~ul.imgs>li:nth-child(3){
    left: 0;
    transition: 0.5s;
    z-index:1;
}


</style>
<h3>오늘의글</h3>

<div class ="slider">
<input type ="radio" name="slide" id="slide1" checked>
<input type ="radio" name="slide" id="slide2" >
<input type ="radio" name="slide" id="slide3" >
<input type ="radio" name="slide" id="slide4" >
<ul id="imgholder" class="imags">
<li><img src = "images/1.png"  width="400px" ></li>
<li><img src = "images/2.png"  width="400px" ></li>
<li><img src = "images/3.png"  width="400px" ></li>
</ul>
<div class = "bullets">
<label for="slide1">&nbsp;</label>
<label for="slide2">&nbsp;</label>
<label for="slide3">&nbsp;</label>
</div>
</div>

</main>
<br>
   <footer>
   <pre>
   JSP란 (Java Server Pages)
   	웹 컨테이너(WAS) 안에 동적 컴파일 과정은
   	xxx_jsp -> xxx_jsp.java -> xxx_jsp.class -> xxx_jsp.obj
   	ⓒ rim Corp.
   </pre>

</body>
</html>

