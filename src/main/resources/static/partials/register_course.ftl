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
                        <input type="hidden" ng-model="course.id">
                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="title">Titre</label>
                                <input type="text" id="title" class="form-control" id="title" name="title" title="Entrez Le titre du cours" ng-minlength="2" ng-maxlength="100" ng-model="course.title" placeholder="Le titre du cours" required>
                                <span style="color: red;" ng-if="courseForm.title.$error.maxlength && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre trop long!</span>
                                <span style="color: red;" ng-if="courseForm.title.$invalid && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre Invalide</span>
                                <span style="color: red;" ng-if="courseForm.title.$error.required &&  (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre obligatoire!</span>
                                <span style="color: red;" ng-if="courseForm.title.$error.minlength && (courseForm.title.$dirty ||  courseForm.title.$touched)">Titre trop court!</span>
                            </div>
                            <div class="col-md-6 col-x-12">
                                <label class="control-label" for="price">Prix</label>
                                <input type="number" id="price" pattern="[0-9]" ng-mdodel="price.value" name="price"  step="0.01" title="Le prix du cours" class="form-control" required>
                                <span style="color: red;" ng-if="courseForm.price.$invalid && (courseForm.price.$dirty ||  courseForm.price.$touched)">Prix Invalide!! </span>
                                <span style="color: red;" ng-if="courseForm.price.$error.required && (courseForm.price.$dirty ||  courseForm.price.$touched) ">Prix obligatoire!!  </span>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="category">Catégorie</label>
                                <select class="form-control"
                                        title="Choisit une catégorie"
                                        name="category"
                                        ng-model="course.category"
                                        ng-options="category.name for category in categories track by category.id" id="category"
                                <#--ng-change="ctrl.categoryChanged(ctrl.selectedCine)" -->
                                        required>
                                    <option value="">--Choisit une catégorie--</option>
                                </select>
                                <span style="color: red;" ng-show="courseForm.category.$error.required && (courseForm.title.$dirty ||  courseForm.title.$touched)">Catégory requis!</span>
                            </div>
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="start_date">Début du cours</label>
                                <input type="date" data-date-format="dd/MMMM/yyyy" id="start_date" class="form-control"  id="start_date" ng-model="course.start_date" placeholder="Dâte de commencement" title="Choisit la dâte du debut" required>
                                <span style="color: red;" ng-show="myForm.start_date.$error.required && (courseForm.start_date.$dirty ||  courseForm.start_date.$touched)">Début du cours requis</span>
                                <span style="color: red;" ng-show="myForm.start_date.$invalid && (courseForm.start_date.$dirty ||  courseForm.start_date.$touched)">Date Invalide</span>
                            </div>
                        </div>

                        <div class="row form-group">
                            <div class="col-md-6 col-xs-12">
                                <label class="control-label" for="price">Duration</label>
                                <input type="number" id="duration" name="duration"  min="0" ng-mdodel="duration.value" name="duration" title="Le durée du cours" class="form-control" required>
                                <span style="color: red;" ng-if="courseForm.duration.$invalid && (courseForm.duration.$dirty ||  courseForm.duration.$touched)">Prix Invalide!</span>
                                <span style="color: red;" ng-if="courseForm.duration.$error.required && (courseForm.duration.$dirty ||  courseForm.duration.$touched) ">Prix obligatoire!</span>
                            </div>
                            <div  class="col-md-6 col-xs-12">
                                <label for="is_premium" class="control-label">Est premium</label>
                                <md-switch class="md-primary" name="is_premium" ng-model="course.is_premium" required>
                                    Est premium.
                                </md-switch>
                            </div>
                        </div>
                        <h4>Syllabus</h4>
                        <div class="row form-group">
                            <div class="col-md-12">
                                <label class="control-label" for="about">A propos du cours</label>
                                <textarea name="about" id="about" cols="40" rows="10" class="form-control" title="Definir le syllabus du cours" ng-model="course.syllabus.about" placeholder="Syllabus du cours" required></textarea>
                                <span style="color: red;" ng-if="courseForm.about.$error.maxlength && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus trop long!</span>
                                <span style="color: red;" ng-if="courseForm.about.$invalid && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus Invalide</span>
                                <span style="color: red;" ng-if="courseForm.about.$error.required &&  (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus obligatoire!</span>
                                <span style="color: red;" ng-if="courseForm.about.$error.minlength && (courseForm.about.$dirty ||  courseForm.about.$touched)">Syllabus trop court!</span>
                            </div>
                        </div>
                <md-card-actions layout="row" layout-align="end center">
                    <md-button type="reset" class="md-raised md-warn" ng-click="reset()" >Annuler</md-button>
                    <md-button type="submit" class="md-raised md-primary" ng-click="register()">Enregistrer</md-button>
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
