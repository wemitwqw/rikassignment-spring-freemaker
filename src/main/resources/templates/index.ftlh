<#import "layout.ftlh" as l>

<@l.page>
    <div class="container text-center">
        <div class="row mb-4">
            <div class="col">
                <div class="d-flex justify-content-center">
                    Lorem ipsuim Lorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuimLorem ipsuim
                </div>
            </div>
            <div class="col">
                Image
            </div>
        </div>
        <div class="row">
            <div class="col">
                <table>
                    <#list events as event>
                        <tr>
                            <td>${event.name}</td>
                            <td>${event.date}</td>
                        </tr>
                    </#list>
                </table>
            </div>
            <div class="col">
                Column
            </div>
            <div class="col">
                Column
            </div>
        </div>
    </div>
</@l.page>