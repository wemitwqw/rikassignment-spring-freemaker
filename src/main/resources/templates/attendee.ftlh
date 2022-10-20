<#import "layout.ftlh" as l>

<@l.page>
<div class="container text-center">
    <div class="col">
        <div class="row">
            <div class="d-flex align-items-center p-2 fw-bold justify-content-center bg-primary text-white">
                Osavõtja info
            </div>
        </div>
        <div class="container d-flex justify-content-center align-items-center text-center">
            <form action="/attendee/${attendee.getId()}" method="post">
                <#if attendee.isPerson()>
                <div class="form-group" id="individual-firstname">
                    <label class="col-sm-2 col-form-label" for="firstname">Eesnimi</label>
                    <input type="text" class="form-control" id="firstname" name="firstname" value="${attendee.getFirstName()}">
                </div>
                <div class="form-group" id="individual-lastname">
                    <label class="col-sm-2 col-form-label" for="lastname">Perenimi</label>
                    <input type="text" class="form-control" id="lastname" name="lastname" value="${attendee.getLastName()}">
                </div>
                <div class="form-group">
                    <label for="code" id="codelabel">Isikukood</label>
                    <input type="text" class="form-control" id="code" name="code" value="${attendee.getCode()}">
                </div>
                <div class="form-group">
                    <label for="payment">Maksmisviis</label>
                    <select class="form-control" id="payment" name="payment">
                        <#if attendee.getPayment()=="CASH">
                            <option selected>Sularaha</option>
                            <option>Ülekanne</option>
                        <#else>
                            <option>Sularaha</option>
                            <option selected>Ülekanne</option>
                        </#if>
                    </select>
                </div>
                <div class="form-group">
                    <label for="desc">Lisainfo</label>
                    <textarea class="form-control" id="desc" name="desc" rows="3"><#if attendee.getDescription()??>${attendee.getDescription()}<#else></#if></textarea>
                </div>
                <#else>
                <div class="form-group" id="company-name">
                    <label class="col-sm-2 col-form-label" for="name">Nimi</label>
                    <input type="text" class="form-control" id="name" name="name" value="${attendee.getBusinessName()}">
                </div>
                <div class="form-group">
                    <label for="code" id="codelabel">Reg. nr</label>
                    <input type="text" class="form-control" id="code" name="code" value="${attendee.getCode()}">
                </div>
                <div class="form-group">
                    <label for="payment">Maksmisviis</label>
                    <select class="form-control" id="payment" name="payment">
                        <#if attendee.getPayment()=="CASH">
                            <option selected>Sularaha</option>
                            <option>Ülekanne</option>
                        <#else>
                            <option>Sularaha</option>
                            <option selected>Ülekanne</option>
                        </#if>
                    </select>
                </div>
                <div class="form-group">
                    <label for="desc">Lisainfo</label>
                    <textarea class="form-control" id="desc" name="desc" rows="3"><#if attendee.getDescription()??>${attendee.getDescription()}<#else></#if></textarea>
                </div>
                </#if>
                <button type="submit" class="btn btn-primary mb-2">Salvesta</button>
            </form>
        </div>
    </div>
</div>
</@l.page>