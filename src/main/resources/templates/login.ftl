<div ng-controller="LoginController">
<div>

    <div class="container">
        <div class="row">
            <div class="col-xs-12">
                <div class="row">
                    <div class="col-sm-4 col-sm-offset-4 col-xs-10 col-xs-offset-1">

                        <div class="loginWith">
                            <h6><b style="color: brown">Se connecter avec:</b></h6>

                            <form action="/connect/google" method="POST" style="display: inline">
                                <input type="hidden" name="scope" value="profile email" />
                                <button type="submit" class="btn-link fa fa-google noBorder">oogle
                                </button>
                            </form>

                            <form action="/connect/facebook" method="POST" style="display: inline">
                                <input type="hidden" name="scope" value="public_profile,email" />
                                <button type="submit" class="btn-link fa fa-facebook noBorder">acebook
                                </button>
                            </form>

                            <form action="/connect/linkedin" method="POST" style="display: inline">
                                <input type="hidden" name="scope" value="public_profile,email" />
                                <button type="submit" class="btn-link fa fa-linkedin noBorder"> linkedin
                                </button>
                            </form>
                        </div>

                        <div class="signUpForm">
                            <div class="head">
                                <img src="/images/course_1.jpg" alt="Subscribe"/>
                            </div>
                            <div class="alert alert-danger" ng-show="error">
                                There was a problem logging in. Please try again.
                            </div>
                            <form role="form" ng-submit="login()" class="flp">

                                <div class="input-group has-feedback">
                                    <label class="sr-only" for="exEmail">Email ou Nom d'utilisateur</label>
                                    <input style="height: 50px" type="email" class="form-control" id="exEmail"
                                           placeholder="Email ou Nom d'utilisateur" ng-model="credentials.email">
                                    <div class="input-group-addon"><i class="fa fa-envelope"></i></div>
                                </div>
                                <div class="input-group">
                                    <label class="sr-only" for="exPassword">Mot de passe</label>
                                    <input style="height: 50px" type="password" class="form-control" id="exPassword"
                                           placeholder="Mot de passe" ng-model="credentials.password">
                                    <div class="input-group-addon"><i class="fa fa-lock"></i></div>
                                </div>
                                <button type="submit" class="btn btn-primary btn-block" id="loading-example-btn"
                                        data-loading-text="Logining in...">Conexion
                                </button>
                                <button type="button" class="btn btn-success btn-block pb-modalreglog-submit"
                                        data-toggle="modal" data-target="#myModal2">S'inscrire
                                </button>
                                <a href="/">Forgot Password?</a>
                            </form>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<div class="modal fade" id="myModal2" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">Registration form</h4>
            </div>
            <div class="modal-body">
                <form class="pb-modalreglog-form-reg">
                    <div class="form-group">
                        <div id="pb-modalreglog-progressbar"></div>
                    </div>
                    <div class="form-group">
                        <label for="email">Email address</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                            <input type="email" class="form-control" id="inputEmail" placeholder="Email">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="password">Password</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" id="inputPws" placeholder="Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="confirmpassword">Confirm password</label>
                        <div class="input-group pb-modalreglog-input-group">
                            <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                            <input type="password" class="form-control" id="inputConfirmPws"
                                   placeholder="Confirm Password">
                        </div>
                    </div>

                    <div class="form-group">
                        <input type="checkbox" id="ch" name="chs"> I agree with <a href="#">terms and conditions.</a>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">S'inscrire</button>
            </div>
        </div>
    </div>
</div>
</div>