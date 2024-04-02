<template>
    <div>
        <v-radio-group v-model="radios" :mandatory="false">
            <v-row>
                <p class="question">1. Is Bidder ISO Certifed</p>
                <v-radio label="Yes" class="my-radio" value="ISOCertifiedYes"></v-radio>
                <v-radio label="No" class="my-radio" value="ISOCertifiedNo"></v-radio>
            </v-row>
        </v-radio-group>
        <v-radio-group v-model="radios" :mandatory="false">
            <v-row>
                <p class="question">2. Are Technical measurements details stisfactory to requirement</p>
                <v-radio label="Yes" class="my-radio" value="Tech2Yes"></v-radio>
                <v-radio label="No" class="my-radio" value="Tech2No"></v-radio>
            </v-row>
        </v-radio-group>
    </div>
</template>

<script>
export default {
    name: 'TechnicalDocumentEvaluation',
}
</script>

<style lang="scss" scoped>
.my-radio {
    margin: 10px;
}
.question {
    margin: 10px;
    margin-right: 30px;
    top: 50%;
}
</style>