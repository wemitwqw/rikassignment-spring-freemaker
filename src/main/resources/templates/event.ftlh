<#import "layout.ftlh" as l>

    <script src="/attendees.js" defer></script>
<@l.page>
    <div class="container d-flex justify-content-center align-items-center text-center">
        <div class="row"></div>
        <div class="row">
            <div class="col-4"></div>
            <div class="col-12">
                <div class="row">
                    Osavõtjad
                </div>
                <div class="row">
                    Ürituse nimi: ${event.name}<br>
                    Toimumisaeg: ${event.date} ${event.time}<br>
                    Koht: ${event.place}<br>
                    Osavõtjad: <br>
                    <#list event.getAttendees() as att>
                        ${att?index+1}.
                        <#if att.getBusinessName()??>${att.getBusinessName()}<#else>${att.getFirstName()} ${att.getLastName()}</#if>
                        ${att.getCode()}
                        <a class="no-decorator" href="/attendee/${att.getId()}">Vaata</a>
                        <a class="no-decorator" href="/attendee/del/${event.id}/${att.getId()}">Kustuta</a>
                        <br>
                    </#list>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-4">
            <div class="col-12">
                <div class="row">
                    Osavõtjate lisamine
                </div>
                <div class="row">
                    <form action="/attendee/add/${event.id}" method="post">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="selector" id="individual" value="option1" checked >
                            <label class="form-check-label" for="individual">
                                Eraisik
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="selector" id="company" value="option2">
                            <label class="form-check-label" for="company">
                                Ettevõte
                            </label>
                        </div>
                        <div class="form-group hidden" id="company-name">
                            <label class="col-sm-2 col-form-label" for="name">Nimi</label>
                            <input type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="form-group" id="individual-firstname">
                            <label class="col-sm-2 col-form-label" for="firstname">Eesnimi</label>
                            <input type="text" class="form-control" id="firstname" name="firstname">
                        </div>
                        <div class="form-group" id="individual-lastname">
                            <label class="col-sm-2 col-form-label" for="lastname">Perenimi</label>
                            <input type="text" class="form-control" id="lastname" name="lastname">
                        </div>
                        <div class="form-group">
                            <label for="code" id="codelabel">Isikukood</label>
                            <input type="text" class="form-control" id="code" name="code">
                        </div>
                        <div class="form-group">
                            <label for="payment">Maksmisviis</label>
                            <select class="form-control" id="payment" name="payment">
                                <option>Sularaha</option>
                                <option>Ülekanne</option>
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="desc">Lisainfo</label>
                            <textarea class="form-control" id="desc" name="desc" rows="3"></textarea>
                        </div>
                        <button type="submit" class="btn btn-primary mb-2">Lisa osalejat</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</@l.page>