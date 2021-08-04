<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>투어</title>

    <%--    <%@ include file="/inc/asset.jsp" %>--%>

    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }

        body > section.main-section > {
            display: flex;
        }

        body > section.main-section > div {
            flex: 1 1 auto;
            width: 700px;
            align-content: center;
        }

        body > section.main-section > div div > div > div > div > div > div > small {
            font-size: 22px;
        }

        /*body > section.main-section > div{*/
        /*    width: 700px;*/
        /*    display: inline-block;*/
        /*}*/
        /*body > section.main-section > div > div > div > div > div{*/
        /*    width: 500px;*/
        /*}*/

    </style>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>

</head>
<body>
<!-- template.jsp -->
<%@ include file="/inc/header.jsp" %>
<%--private String tourseq;--%>
<%--private String name;--%>
<%--private String detail;--%>
<%--private String use;--%>
<%--private String validdate;--%>
<%--private String tourprice;--%>
<%--private String img;--%>
<section class="main-section">
    <c:forEach items="${dto}" var="dto">
        <div class="album py-5 bg-light">
            <div class="container">

                <div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
                    <div class="col">
                        <div class="card shadow-sm">
                            <img src="${dto.img}" alt="장소 이미지">
                            <div class="card-body">
                                <p class="card-text">${dto.detail}</p>
                                <div class="d-flex justify-content-between align-items-center">
                                    <div class="btn-group">
                                            <%--                                        begin modal--%>

                                        <!-- Button trigger modal -->
                                        <button type="button" class="btn btn-primary" data-bs-toggle="modal"
                                                data-bs-target="#exampleModal">
                                            예약하기
                                        </button>

                                        <!-- Modal -->
                                        <div class="modal fade" id="exampleModal" tabindex="-1"
                                             aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog modal-dialog-centered">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">${dto.name}
                                                            예약</h5>
                                                        <button type="button" class="btn-close" data-bs-dismiss="modal"
                                                                aria-label="Close"></button>
                                                    </div>
                                                    <form method="POST" action="/SIST2_Travel/tour/booktour.do">
                                                        <div class="modal-body">

                                                            <div class="mb-3">
                                                                <label for="name" class="col-form-label">이름:
                                                                </label>
                                                                <input type="text" class="form-control" id="name"
                                                                       name="name">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="regdate" class="col-form-label">예약일자:
                                                                </label>
                                                                <input type="text" class="form-control" id="regdate"
                                                                       name="regdate">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="personnel" class="col-form-label">인원:
                                                                </label>
                                                                <input type="text" class="form-control"
                                                                       id="personnel" name="personnel">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="contact" class="col-form-label">연락처:
                                                                </label>
                                                                <input type="text" class="form-control" id="contact"
                                                                       name="contact">
                                                            </div>
                                                            <div class="mb-3">
                                                                <label for="email" class="col-form-label">이메일:
                                                                </label>
                                                                <input type="text" class="form-control" id="email"
                                                                       name="email">
                                                            </div>

                                                            <div class="mb-3">
                                                                <label for="moredetail" class="col-form-label">추가 내용:
                                                                </label>
                                                                <textarea class="form-control"
                                                                          id="moredetail" name="moredetail"
                                                                          style="height: 200px"></textarea>
                                                            </div>
                                                            <input type="hidden" value="${dto.tourseq}" name="tourseq">

                                                        </div>
                                                        <div class="modal-footer">
                                                            <button type="button" class="btn btn-secondary"
                                                                    data-bs-dismiss="modal">닫기
                                                            </button>
                                                            <button type="submit" class="btn btn-primary">예약 완료
                                                            </button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                            <%--                                        end modal--%>
                                    </div>
                                    <small class="text-muted">${dto.tourprice}원</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </c:forEach>
</section>
<%@ include file="/inc/init.jsp" %>
<%@ include file="/inc/footer.jsp" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>

<script>

</script>
</body>
</html>















