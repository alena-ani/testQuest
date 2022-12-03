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
        <div class="alert alert-success" role="alert">
            <h3>Prologue</h3>
            You are standing in the space port and ready to board your ship.
            Didn't you dream about it? Become the captain of a galactic
            ship with a crew that will perform feats under your command.
            <h4>Getting to know the crew</h4>
            When you boarded the ship, you were greeted by a girl with a black folder in her hands:
            - Hello, commander! I am Zinaida - your assistant. See? There, in the corner, our navigator and flight
            mechanic
            are drinking coffee.
            And what is your name?
        </div>

        <form method="post" action="index" class="row g-3">
            <div class="col-md-12">
                <label for="username" class="form-label">Your name</label>
                <input type="text" id="username" class="form-control" name="name" placeholder="Enter your name"
                       aria-label="Enter your name">
            </div>
            <div class="col-md-12">
                <button type="submit" class="btn btn-primary">Enter</button>
            </div>
        </form>
    </div>
</main>

<footer class="footer mt-auto py-3 bg-light">
    <div class="container">
        <!-- Button trigger modal -->
        <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#statisticModal">
            Statistics
        </button>

        <!-- Modal -->
        <div class="modal fade" id="statisticModal" tabindex="-1" aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h1 class="modal-title fs-5" id="exampleModalLabel">Statistics</h1>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="modal-body">
                            <div>Current player: ${statistics.userName}</div>
                            <div>IP adrdess: ${statistics.ipAddress}</div>
                            <div>Number of games: ${statistics.numberOfGames}</div>
                        </div>
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

