<#import "layout.ftlh" as l>

<@l.page>
    <div class="container text-center">
        <div class="row fw-bold mb-3 d-flex justify-content-center align-items-center bg-primary text-white">
            <div class="col-6 ps-0 pe-2">
                <div class="">
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
                </div>
            </div>
            <div class="col-6 ps-0 pe-0">
                <div class="cover">
                    <img src="/connectwithnature.jpg" width="100%">
<#--                    <img src="/img.jpg">-->
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col">
                <div class="row">
                    <div class="d-flex align-items-center p-2 fw-bold justify-content-center bg-primary text-white">
                        Tulevased üritused
                    </div>
                </div>
                <div class="row">
                    <table class="table">
                        <thead>
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Üritus</th>
                            <th scope="col">Kuupäev</th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list events as event>
                            <tr>
                                <th>${event?index+1}.</th>
                                <td>${event.name}</td>
                                <td>${event.date}</td>
                                <td><a href="/event/${event.id}">Osalejad</a></td>
                            </tr>
                        </#list>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col">
                Column
            </div>
        </div>
    </div>
</@l.page>