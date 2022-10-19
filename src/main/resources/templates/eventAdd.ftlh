<#import "layout.ftlh" as l>

<@l.page>
    <div class="container d-flex justify-content-center align-items-center text-center">
        <form action="/event/add" method="post">
            <div class="form-group">
                <label for="name">Ürituse nimi</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="form-group">
                <label for="date">Kuupäev</label>
                <input type="date" class="form-control" id="date" name="date">
            </div>
            <div class="form-group">
                <label for="time">Kuupäev</label>
                <input type="time" class="form-control" id="time" name="time">
            </div>
            <div class="form-group">
                <label for="place">Koht</label>
                <input type="text" class="form-control" id="place" name="place">
            </div>
            <div class="form-group">
                <label for="desc">Kirjeldus</label>
                <textarea class="form-control" id="desc" name="desc" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary mb-2">Lisa üritust</button>
        </form>
    </div>
</@l.page>