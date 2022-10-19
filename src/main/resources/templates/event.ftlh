<#import "layout.ftlh" as l>

<@l.page>
    <div class="container d-flex justify-content-center align-items-center text-center">
        <#if event??>
            <form action="/event/add" method="post">
                <input type="text" value="${event.id}" name="id"><br>
                <input type="text" value="${event.name}" name="name"><br>
                <input type="text" value="${event.date}" name="date"><br>
                <input type="text" value="${event.time}" name="time"><br>
                <#list event.attendees as attendee>
                    <input type="text" value="${attendee.name}" name="time"><br>

                </#list>
<#--                <input type="text" value="${_csrf.token}" name="_csrf">-->
                <button type="submit">Salvesta</button>
            </form>
        <#else>
            <form action="/event/add" method="post">
                <input type="text" value="" name="name">
<#--                <input type="text" value="${_csrf.token}" name="_csrf">-->
                <button type="submit">Salvesta</button>
            </form>
        </#if>
    </div>
</@l.page>