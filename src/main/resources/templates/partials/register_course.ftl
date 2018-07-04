<div class="container">

        <md-card md-theme="{{ showDarkTheme ? 'dark-grey' : 'default' }}" md-theme-watch="">
                <md-content class="md-padding" layout="column" layout-xs="row">

                    <div class="alert alert-danger" role="alert" ng-show="message">{{message}}</div>
                    <form name="courseForm">
                        <md-card-title>
                            <md-card-title-text>
                                <span class="md-headline">Ajouter un nouveau cours</span>
                            </md-card-title-text>
                        </md-card-title>
                        <hr>
                        <input type="hidden" ng-model="rc_ctrl.course.id">
                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="title">Titre</label>
                                <input type="text"
                                       submit-required="true"
                                       id="title"
                                       class="form-control"
                                       name="title"
                                       title="Entrez Le titre du cours"
                                       ng-minlength="2"
                                       ng-maxlength="100"
                                       ng-model="rc_ctrl.course.title"
                                       placeholder="Le titre du cours"
                                       required>
                                <span style="color: red;" ng-if="courseForm.title.$error.maxlength && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre trop long!</span>
                                <span style="color: red;" ng-if="courseForm.title.$invalid && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre Invalide</span>
                                <span style="color: red;" ng-if="courseForm.title.$error.required &&  (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre obligatoire!</span>
                                <span style="color: red;" ng-if="courseForm.title.$error.minlength && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre trop court!</span>
                            </div>
                            <div class="col-md-6 col-x-12">
                                <label class="control-label" for="price">Prix</label>
                                <input type="number"
                                       id="price"
                                       ng-mdodel="rc_ctrl.course.price"
                                       name="price"
                                       title="Le prix du cours"
                                       class="form-control"
                                       required>
                                <span style="color: red;" ng-if="courseForm.price.$invalid && (courseForm.price.$dirty ||  courseForm.price.$touched)">Prix Invalide!! </span>
                                <span style="color: red;" ng-if="courseForm.price.$error.number && (courseForm.price.$dirty ||  courseForm.price.$touched)">Prix error!! </span>
                                <span style="color: red;" ng-if="courseForm.price.$error.required && (courseForm.price.$dirty ||  courseForm.price.$touched) ">Prix obligatoire!!  </span>
                                {{course.price}}
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="category">Catégorie</label>
                                <select class="form-control"
                                        submit-required="true"
                                        title="Choisit une catégorie"
                                        name="category"
                                        ng-model="rc_ctrl.course.category"
                                        ng-options="category.name for category in categories track by category.id"
                                        id="category"
                                <#--ng-change="ctrl.categoryChanged(ctrl.selectedCine)" -->
                                      >
                                    <option value="">--Choisit une catégorie--</option>
                                </select>
                                <span style="color: red;" ng-show="courseForm.category.$error.required && (courseForm.category.$dirty ||  courseForm.category.$touched)">Catégory requis!</span>
                            </div>
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="startDate">Début du cours</label>
                                <input type="date" submit-required="true"  data-date-format="dd/MMMM/yyyy" class="form-control"  id="startDate" ng-model="course.startDate" placeholder="Debut du Cours" title="Choisit la dâte du debut" required>
                                <span style="color: red;" ng-show="courseForm.startDate.$error.required && (courseForm.startDate.$dirty ||  courseForm.startDate.$touched)">Début du cours requis</span>
                                <span style="color: red;" ng-show="courseForm.startDate.$invalid && (courseForm.startDate.$dirty ||  courseForm.startDate.$touched)">Date Invalide</span>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="duration">Duration</label>
                                <input type="number"
                                       submit-required="true"
                                       id="duration"
                                       name="duration"
                                       min="0"
                                       ng-mdodel="rc_ctrl.duration.value"
                                       name="duration" title="Le durée du cours"
                                       class="form-control"
                                       required>
                                <span style="color: red;" ng-if="courseForm.duration.$invalid && (courseForm.duration.$dirty ||  courseForm.duration.$touched)">Prix Invalide!</span>
                                <span style="color: red;" ng-if="courseForm.duration.$error.required && (courseForm.duration.$dirty ||  courseForm.duration.$touched) ">Prix obligatoire!</span>
                            </div>
                            <div  class="col-md-6 col-xs-12">
                                <label for="premium" class="control-label">Est premium</label>
                                <md-switch class="md-primary" name="premium" ng-model="course.premium">
                                    Est premium.
                                </md-switch>
                            </div>
                        </div>
                        <h4>Syllabus</h4>
                        <div class="row form-group">
                            <div class="col-md-12">
                                <label class="control-label" for="about">A propos du cours</label>
                                <textarea name="about"
                                          submit-required="true"
                                          id="about"
                                          cols="40"
                                          rows="10"
                                          class="form-control"
                                          title="Definir le syllabus du cours"
                                          ng-model="rc_ctrl.course.syllabus.about"
                                          placeholder="Syllabus du cours"
                                          required></textarea>
                                <span style="color: red;" ng-if="courseForm.about.$error.maxlength && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus trop long!</span>
                                <span style="color: red;" ng-if="courseForm.about.$invalid && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus Invalide</span>
                                <span style="color: red;" ng-if="courseForm.about.$error.required &&  (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus obligatoire!</span>
                                <span style="color: red;" ng-if="courseForm.about.$error.minlength && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus trop court!</span>
                            </div>
                        </div>
                <md-card-actions layout="row" layout-align="end center">
                    <md-button type="reset" class="md-raised md-warn" ng-click="rc_ctrl.reset()" >Annuler</md-button>
                    <md-button type="submit" class="md-raised md-primary" ng-click="rc_ctrl.register()">Enregistrer</md-button>
                </md-card-actions>
            </form>
        </div>

        </md-content>

        </md-card>
</div>
<script>
    $(document).ready(function(){
        $('#start_date').prop('min', new Date())

        console.log(document.getElementById('start_date'));
    });


</script>
