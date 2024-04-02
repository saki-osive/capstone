<template>
    <div>
        <v-card color="blue" class="mx-auto" outlined>
            <v-card-title class="justify-center">Documents Upload</v-card-title>
            <v-data-table :headers="headers" :items="cover">
                <template v-slot:item.viewdoc="{ item }">
                    <v-btn icon>
                        <v-icon v-model="item.glutenfree">fa-file-alt</v-icon>
                    </v-btn>
                </template>
            </v-data-table>
        </v-card>
    </div>
</template>

<script>
export default {
    name: 'ReviewDocuments',
    data() {
        return {
            
            headers: [
                {
                    text: 'S.No.',
                    value: 'sno',
                },
                { text: 'Cover Name', value: 'name' },
                { text: 'Cover Type', value: 'type' },
                { text: 'Cover Document', value: 'doc' },
                { text: 'Docs', value: 'viewdoc' },
            ],
            cover: [
                {
                    sno: 1,
                    name: 'GST Registration Certificate',
                    type: 'Standard Attachment',
                    doc: 0,
                },
                {
                    sno: 2,
                    name: 'Scan Copy of Certificate of Incorporation',
                    type: 'Standard Attachment  ',
                    doc: 0,
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped>
</style>