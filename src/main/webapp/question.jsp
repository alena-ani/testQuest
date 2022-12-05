<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en" class="h-100">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>My super project!</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
</head>
<body class="d-flex flex-column h-100">
<main class="flex-shrink-0">
    <div class="container">
        Hello, ${userName}
        <hr>
        <div>
            <strong>${question.text}</strong>
        </div>
        <br/>
        <c:if test="${question.getAnswers() != null && !question.getAnswers().isEmpty()}">
            <form method="POST" action="question" class="row">
                <div class="col-12">
                    <c:forEach var="answer" items="${question.answers}">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="answer" id="${answer.id}" value="${answer.id}">
                            <label class="form-check-label" for="${answer.id}">
                                    ${answer.text}
                            </label>
                        </div>
                    </c:forEach>
                    <input type="hidden" name="question" value="${question.id}">
                </div>
                <div class="col-md-12">
                    <button class="btn btn-primary" type="submit">Submit</button>
                </div>
            </form>
        </c:if>
        <c:if test="${question.getAnswers() == null || question.getAnswers().isEmpty()}">
            <div class="col-md-12">
                <a href="./index">Play again</a>
            </div>
        </c:if>
    </div>
</main>

<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#statisticModal">
            Statistics
        </button>

        <!-- Modal -->
        <div class="modal fade" id="statisticModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Statistics</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div>Current player: ${statistics.userName}</div>
                        <div>IP adrdess: ${statistics.ipAddress}</div>
                        <div>Number of games: ${statistics.numberOfGames}</div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</footer>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4"
        crossorigin="anonymous"></script>
</body>
</html>
