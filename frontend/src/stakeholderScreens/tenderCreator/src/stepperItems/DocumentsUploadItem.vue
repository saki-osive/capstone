<template>
    <div>
        <v-card color="blue" class="mx-auto" outlined>
            <v-card-title class="justify-center">Documents Upload</v-card-title>
            <v-data-table :headers="headers" :items="cover">
                <template v-slot:item.adddoc="{ item }">
                    <v-file-input ref="inputUpload" v-model="item.file"  v-on:change="handleFileUpload(item)" dense></v-file-input>
                </template>
            </v-data-table>
        </v-card>
    </div>
</template>

<script>
export default {
    name: 'DocumentsUploadItem',
    methods:{
        handleFileUpload(item){

            console.log(item.name);
            let file = item.file
            console.log(file)
        }
    },
    data() {
        return {
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
            cover: [
                {
                    sno: 1,
                    name: 'Tender Document',
                    type: 'Standard Attachment',
                    doc: 0,
                    file:null
                },
                {
                    sno: 2,
                    name: 'SOR(Schedule Of Rate)',
                    type: 'Standard Attachment  ',
                    doc: 0,
                    file:null
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
