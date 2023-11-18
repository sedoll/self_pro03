<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<c:set var="path" value="<%=request.getContextPath() %>" />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>티스푼 메인 페이지</title>
    <jsp:include page="./include/head.jsp"/>
    <!-- 슬라이드 -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.css"/>

    <style>
        .swiper {
            max-height: 100vh;
            z-index: 2;
        }
    </style>
</head>
<body>
    <jsp:include page="./include/header.jsp"/>
    <section class="hero-area has-background-primary" id="parallax" style="padding-top: 0;">

        <!-- slidebar banner -->
        <div class="swiper mySwiper">
            <div class="swiper-wrapper">
                <div class="swiper-slide">
                    <img src="${path }/resources/img/index_1.png" alt="메인페이지 배너1" style="width: 100vw">
                </div>
                <div class="swiper-slide">
                    <img src="${path }/resources/img/index_2.png" alt="메인페이지 배너2" style="width: 100vw">
                </div>
                <div class="swiper-slide">
                    <img src="${path }/resources/img/index_3.png" alt="메인페이지 배너3" style="width: 100vw">
                </div>
                <div class="swiper-slide">
                    <img src="${path }/resources/img/index_4.png" alt="메인페이지 배너4" style="width: 100vw">
                </div>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
            <div class="swiper-pagination"></div>
        </div>

        <!-- Swiper JS -->
        <script src="https://cdn.jsdelivr.net/npm/swiper@10/swiper-bundle.min.js"></script>

        <!-- Initialize Swiper -->
        <script>
            var swiper = new Swiper(".mySwiper", {
                spaceBetween: 30,
                centeredSlides: true,
                loop: true, // 무한 루프
                autoplay: {
                    delay: 3000,
                    disableOnInteraction: false,
                },
                pagination: {
                    el: ".swiper-pagination",
                    clickable: true,
                },
                navigation: {
                    nextEl: ".swiper-button-next",
                    prevEl: ".swiper-button-prev",
                },
            });
        </script>
    </section>
    <div class="content" id="content">
        <div class="row column text-center">
            <div class="container">
                <h2>${not empty newsName ? newsName : '뉴스'} 검색</h2>
                <form action="${path}/news/list.do" method="post">
                    <input type="text" name="search" id="search" class="input" placeholder="뉴스 제목 입력" required autofocus>
                    <input class="button is-primary" type="submit" value="확인">
                </form>
                <hr>
                <article class="media">
                    <div class="media-content">
                        <div class="content" style="margin-left: 150px;  margin-right: 150px;">
                            <c:forEach var="item" items="${titleList}" varStatus="status"> <%-- 가져온 url중 64-72번째만 나오게한다--%>
                                <br>
                                <p>
                                    <a href="${urlList.get(status.index)}" target="_blank"><strong style="color: black;font-size: 30px;font-weight: bold;">${titleList.get(status.index)}</strong></a>   <small>${companyList.get(status.index)}</small>
                                    <br><br>
                                        ${textList.get(status.index)}..<a href="${urlList.get(status.index)}" style="color: black">더보기</a>
                                <hr>
                                </p>
                            </c:forEach>
                        </div>
                    </div>
                </article>
                <hr>
            </div>

        </div>
    </div>
    <jsp:include page="./include/footer.jsp"/>
</body>
</html>