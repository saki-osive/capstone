<template>
    <div>
        <v-card color="blue" class="mx-auto" outlined>
            <v-card-title class="justify-center">Documents Upload</v-card-title>
            <v-data-table :headers="headers" :items="documents">
                <template v-slot:item.adddoc="{ item }">
                    <v-file-input ref="inputUpload" v-model="item.file"  v-on:change="handleFileUpload(item)" dense></v-file-input>
                </template>
            </v-data-table>
        </v-card>
        <br />
        <v-card class="max-auto" width="90%" flat>
            <v-row>
                <v-alert type="info" class="blue lighten-2" width="100%">
                    <p>All the content of the tender document have been read and understood by me</p>
                    <v-row>
                        <p>
                            <strong>Reply</strong>
                        </p>
                        <v-radio-group v-model="agreementSelected" :mandatory="true">
                            <v-row>
                                <v-radio label="Yes" value="Yes" style="margin:15px;"></v-radio>
                                <v-radio label="No" value="No"></v-radio>
                            </v-row>
                        </v-radio-group>
                    </v-row>
                </v-alert>
            </v-row>
        </v-card>
    </div>
</template>

<script>
export default {
    name: 'UploadDocuments',
    methods:{
        handleFileUpload(item){

            console.log(item.name);
            let file = item.file
            console.log(file)
        }
    },
    data() {
        return {
            agreementSelected:"",
            step: '1',
            headers: [
                {
                    text: 'S.No.',
                    value: 'sno',
                },
                { text: 'Cover Name', value: 'name' },
                { text: 'Cover Type', value: 'type' },
                { text: 'Cover Document', value: 'doc' },
                { text: 'Add Document', value: 'adddoc' },
            ],
            documents: [
                {
                    sno: 1,
                    name: 'Technical Document',
                    type: 'Standard Attachment',
                    doc: 0,
                    file:null
                },
                {
                    sno: 2,
                    name: 'Financial Document',
                    type: 'Standard Attachment  ',
                    doc: 0,
                    file:null
                },
            ],
            
        }
    },
}
</script>

<style lang="scss" scoped>
</style>