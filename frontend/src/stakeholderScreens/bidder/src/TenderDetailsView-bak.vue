<template>
    <v-div class="text-center">
        <h1>Tender Details</h1>
        <br />

        <v-col class="d-flex" cols="8" sm="4">
            <v-select label="Basic Tender Details" dense outlined class="ml-8"></v-select>
        </v-col>
        <v-col class="d-flex" cols="8" sm="4">
            <v-select label="Payment Instructions" dense outlined class="ml-8"></v-select>
        </v-col>
        <br />
        <h2>Bid Submission</h2>
        <br />
        <v-row>
            <v-span class="mx-12">Submit Technical Documents</v-span>
            <v-btn>
                <v-icon>fa-upload</v-icon>Drop files here
            </v-btn>
        </v-row>
        <br />

        <v-row>
            <v-span class="mx-12">Submit Financial Documents</v-span>
            <v-btn>
                <v-icon>fa-upload</v-icon>Drop files here
            </v-btn>
        </v-row>
        <br />
        <div class="text-center">
            <v-btn dark class="blue">Submit Bid</v-btn>
        </div>
    </v-div>
</template>