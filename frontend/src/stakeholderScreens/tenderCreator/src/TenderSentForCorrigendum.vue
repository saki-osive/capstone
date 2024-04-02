<template>
    <div>
        <v-toolbar color="#BD5C38">
            <v-toolbar-title>Corrigendum</v-toolbar-title>
        </v-toolbar>
        <v-row>
            <v-col cols="6">
                <v-text-field
                    v-model="search"
                    append-icon="mdi-magnify"
                    label="Enter Tender Number or Tender Name"
                    solo
                    hide-details
                ></v-text-field>
            </v-col>
        </v-row>
        <br />
        <v-data-table
            :headers="headers"
            :items="tenderSentForCorrigendumItem"
            item-key="name"
            :search="search"
        >
            <template v-slot:item.continue="{ item }">
                <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.continue"
                    text
                    :to="{name: 'CreateTender'}"
                    >Continue</v-btn
                >
                <!-- <v-btn
                    class="blue"
                    dark
                    small
                    v-model="item.refId"
                    text
                    v-on:click="onTenderOnClicked()"
                    >{{refId}}</v-btn
                > -->
            </template>
        </v-data-table>
        <TenderDialog ref="tenderDialog" />
    </div>
</template>

<script>
import TenderDialog from '@/dashboard/layout/TenderDialog.vue'
import {TenderTableHeaders} from "../datasource/TenderTableHeaders";

export default {
    name: 'TenderSentForCorrigendum',
    components: {
        TenderDialog,
    },
    methods: {
        onTenderOnClicked() {
            this.$refs.tenderDialog.show2()
        },
    },
    data() {
        return {
            search: '',
            headers: TenderTableHeaders.header,
            tenderSentForCorrigendumItem: [
                {
                    refId: 'SBYUS676SW',
                    tenderName:
                        'HIRING OF PROJECT MANAGEMENT CONSULTANCY SERVICES FOR IMPLEMENTATION OF PIPELINE PROJECT FROM GAIL’S DBNPL NETWORK TO M/S HMEL, BHATINDA IN PUNJAB REGION',
                    lastCommit: '20.02.2020',
                },
                {
                    refId: 'GYUSF67DSS',
                    tenderName: 'Supply, Installation of MG Anodes',
                    lastCommit: '14.03.2020',
                },
            ],
        }
    },
}
</script>

<style lang="scss" scoped></style>
